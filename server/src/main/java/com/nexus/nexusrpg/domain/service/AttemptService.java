package com.nexus.nexusrpg.domain.service;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.attempt.request.AttemptAnswerRequestDTO;
import com.nexus.nexusrpg.domain.controller.dto.attempt.request.AttemptStartRequestDTO;
import com.nexus.nexusrpg.domain.controller.dto.attempt.response.AttemptResponseDTO;
import com.nexus.nexusrpg.domain.mapper.AttemptMapper;
import com.nexus.nexusrpg.domain.model.relation.Answer;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.AlternativeRepository;
import com.nexus.nexusrpg.domain.repository.AttemptRepository;
import com.nexus.nexusrpg.domain.repository.QuestionRepository;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.validator.AttemptValidator;
import com.nexus.nexusrpg.domain.validator.MissionValidator;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.user.repository.UserRepository;
import com.nexus.nexusrpg.user.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttemptService {

    private final Context context;
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;
    private final QuestionRepository questionRepository;
    private final AlternativeRepository alternativeRepository;
    private final AttemptRepository attemptRepository;
    private final AttemptMapper attemptMapper;
    private final MissionValidator missionValidator;
    private final AttemptValidator attemptValidator;
    private final UserValidator userValidator;
    private final ProgressionService progressionService;

    @Transactional
    public AttemptResponseDTO start(AttemptStartRequestDTO request) {
        var user = userRepository
                .findByIdOrThrow(context.getAuthenticatedUser().getId());
        userValidator.hasEnoughOxygen(user);

        var uMission = getMission(user, request);
        var attempt = Attempt.builder()
                .uMission(uMission)
                .build();

        user.consumeOxygen();
        userRepository.save(user);

        return attemptMapper.map(attemptRepository.save(attempt));
    }

    private UMission getMission(User user, AttemptStartRequestDTO request) {

        var mission = userMissionRepository
                .findByUserIdAndEntityId(
                        user.getId(),
                        request.missionId()
                );

        missionValidator.isAccessible(mission);
        attemptValidator.hasActiveAttempts(mission);

        return mission;
    }

    @Transactional
    public AttemptResponseDTO finish(Long id, List<AttemptAnswerRequestDTO> request) {
        var attempt = attemptRepository.findByIdOrThrow(id);
        attemptValidator.isCurrent(attempt);

        var uMission = attempt.getUMission();
        var exec = uMission.getExecution();
        var mission = uMission.getMission();

        attemptValidator.validateAnswers(request, mission);
        attemptValidator.validateUniqueQuestions(request);

        var responses = createResponses(attempt, request);

        attempt.finish(responses);
        exec.updateBestResult(attempt.getResult());

        var user = uMission.getUser();
        var xpBonus = uMission.getXpBonus();
        updateUserStats(user, xpBonus);

        if (attempt.getResult().compareTo(BigDecimal.valueOf(70)) >= 0) {
            progressionService.unlockNextMission(user, mission);
        }

        return attemptMapper.map(attemptRepository.save(attempt));
    }

    private void updateUserStats(User user, long xpBonus) {
        user.addXp(xpBonus);
        userRepository.save(user);
    }

    private List<Answer> createResponses(Attempt attempt, List<AttemptAnswerRequestDTO> request) {

        return request.stream()
                .map(r -> {
                    var question = questionRepository.getReferenceById(r.questionId());
                    var alternative = alternativeRepository.getReferenceById(r.alternativeId());

                    attemptValidator.validateResponseConsistency(attempt, question, alternative);

                    return Answer.builder()
                            .attempt(attempt)
                            .question(question)
                            .alternative(alternative)
                            .build();
                }).toList();
    }
}
