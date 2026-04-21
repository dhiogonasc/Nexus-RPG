package com.nexus.nexusrpg.domain.entity.mission.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.entity.alternative.model.Alternative;
import com.nexus.nexusrpg.domain.entity.mission.model.UAttempt;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserResponseRepository;
import com.nexus.nexusrpg.domain.entity.question.model.Question;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.domain.entity.mission.repository.UAttemptRepository;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.*;

@Component
@RequiredArgsConstructor
public class AttemptValidator {

    private final UAttemptRepository uAttemptRepository;
    private final UserResponseRepository userResponseRepository;

    public void hasActiveAttempt(UMission mission) {

        boolean hasActive = uAttemptRepository.existsActiveAttempt(mission.getId());

        if (hasActive) {

            throw new BusinessException(
                    "Attempt",
                    "Você já tem uma tentativa em progresso para esta missão.",
                    BAD_REQUEST
            );
        }
    }

    public void isActive(UAttempt attempt) {

        if(!isNull(attempt.getEndAt())){

            throw new BusinessException(
                    "Attempt",
                    "Tentativa finalizada!",
                    BAD_REQUEST
            );
        }
    }

    public void isUserAuth(User user, UAttempt attempt) {

        Long currentUserId = user.getId();
        Long attemptUserId = attempt.getUMission().getUser().getId();

        if(!currentUserId.equals(attemptUserId)){
            throw new BusinessException("Attempt", "Finalização proibida!", UNAUTHORIZED);
        }
    }

    public void isAnswerValid(Alternative alternative, Question question) {

        if (!alternative.getQuestion().getId().equals(question.getId())) {
            throw new BusinessException("Attempt", "Alternativa inválida para esta questão", BAD_REQUEST);
        }
    }

    public void isAlreadyAnswered(Long attemptId, Long questionId) {

        boolean exists = userResponseRepository.existsByAttemptIdAndQuestionId(attemptId, questionId);

        if (exists) {
            throw new BusinessException("Question", "Resposta já registrada para essa tentativa", CONFLICT);
        }
    }
}
