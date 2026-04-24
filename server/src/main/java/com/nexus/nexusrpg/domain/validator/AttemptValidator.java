package com.nexus.nexusrpg.domain.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.controller.dto.attempt.AttemptRequestDTO;
import com.nexus.nexusrpg.domain.model.Alternative;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.Question;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.AttemptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Component
@RequiredArgsConstructor
public class AttemptValidator {

    private final AttemptRepository attemptRepository;

    public void hasActiveAttempts(UMission uMission) {

        var hasActiveAttempt = attemptRepository.existsByUMissionIdAndEndAtIsNull(uMission.getId());

        if(hasActiveAttempt){
            throw new BusinessException(
                    "Attempt",
                    "Você já possui tentativas em curso para essa missão",
                    CONFLICT
            );
        }
    }

    public void isCurrent(Attempt attempt) {

        if(attempt.getEndAt() != null){
            throw new BusinessException(
                    "Attempt",
                    "Tentativa finalizada!",
                    BAD_REQUEST
            );
        }
    }

    public void validateUniqueQuestions(List<AttemptRequestDTO> request) {

        var uniqueQuestions = request.stream()
                .map(AttemptRequestDTO::questionId)
                .distinct()
                .count();

        if (uniqueQuestions != request.size()) {
            throw new BusinessException(
                    "Question",
                    "Existem questões duplicadas na requisição.",
                    UNPROCESSABLE_ENTITY
            );
        }
    }

    public void validateResponseConsistency(
            Attempt attempt,
            Question question,
            Alternative alternative
    ) {
        validateQuestion(attempt, question);
        validateAlternative(question, alternative);
    }

    private void validateQuestion(Attempt attempt, Question question){

        var attemptMissionId = attempt.getUMission().getMission().getId();
        var questionMissionId = question.getMission().getId();

        if (!questionMissionId.equals(attemptMissionId)) {
            throw new BusinessException(
                    "Question",
                    "A questão não pertence a esta missão.",
                    UNPROCESSABLE_ENTITY
            );
        }
    }

    private void validateAlternative(Question question, Alternative alternative){

        var questionId = question.getId();
        var alternativeQuestionId = alternative.getQuestion().getId();

        if (!alternativeQuestionId.equals(questionId)) {
            throw new BusinessException(
                    "Alternative",
                    "A alternativa não pertence a esta questão.",
                    UNPROCESSABLE_ENTITY
            );
        }
    }

    public void validateAnswers(List<AttemptRequestDTO> request, Mission mission) {

        int total = mission.getQuestions().size();
        int answered = request.size();

        if (answered < total) {
            throw new BusinessException(
                    "Mission",
                    "Missão incompleta. Existem questões pendentes na tentativa atual.",
                    UNPROCESSABLE_ENTITY
            );
        }
    }
}
