package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.entity.alternative.repository.AlternativeRepository;
import com.nexus.nexusrpg.domain.entity.level.service.LevelService;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UAttemptDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserResponseDTO;
import com.nexus.nexusrpg.domain.entity.mission.mapper.UAttemptMapper;
import com.nexus.nexusrpg.domain.entity.mission.model.UserResponse;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserResponseRepository;
import com.nexus.nexusrpg.domain.entity.mission.validator.AttemptValidator;
import com.nexus.nexusrpg.domain.entity.mission.validator.MissionValidator;
import com.nexus.nexusrpg.domain.entity.mission.model.UAttempt;
import com.nexus.nexusrpg.domain.entity.mission.repository.UAttemptRepository;
import com.nexus.nexusrpg.domain.repository.relation.UMissionRepository;
import com.nexus.nexusrpg.domain.entity.question.repository.QuestionRepository;
import com.nexus.nexusrpg.user.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.COMPLETED;

@Service
@RequiredArgsConstructor
public class ExecuteMission {

    private final Context context;

    private final LevelService levelService;
    private final ScoreService scoreService;
    private final ProgressionService progressionService;

    private final QuestionRepository questionRepository;
    private final AlternativeRepository alternativeRepository;

    private final UMissionRepository uMissionRepository;
    private final UserResponseRepository userResponseRepository;
    private final UAttemptRepository uAttemptRepository;
    private final UAttemptMapper uAttemptMapper;

    private final UserValidator userValidator;
    private final MissionValidator missionValidator;
    private final AttemptValidator attemptValidator;

    @Transactional
    public UAttemptDTO start(Long missionId) {

        var user = context.getAuthenticatedUser();
        var uMission = uMissionRepository.findByUserIdAndEntityId(user.getId(), missionId);

        missionValidator.isAccessible(uMission);
        attemptValidator.hasActiveAttempt(uMission);
        userValidator.hasEnoughOxygen(user);

        user.consumeOxygen();

        var attempt = UAttempt.builder()
                .uMission(uMission)
                .startAt(LocalDateTime.now())
                .build();

        return uAttemptMapper.toDTO(uAttemptRepository.save(attempt));
    }

    @Transactional
    public void answer(Long attemptId, UserResponseDTO request) {

        var user = context.getAuthenticatedUser();
        var attempt = uAttemptRepository.findByIdOrThrow(attemptId);

        attemptValidator.isUserAuth(user, attempt);
        attemptValidator.isActive(attempt);

        registerAnswer(attempt, request);
    }

    private void registerAnswer(UAttempt attempt, UserResponseDTO request) {

        var questionId = request.questionId();
        var question = questionRepository.findByIdOrThrow(questionId);

        var alternativeId = request.alternativeId();
        var alternative = alternativeRepository.findByIdOrThrow(alternativeId);

        attemptValidator.isAnswerValid(alternative, question);

        var response = userResponseRepository
                .findByAttemptIdAndQuestionId(attempt.getId(), questionId)
                .orElseGet(() -> UserResponse.builder()
                        .attempt(attempt)
                        .question(question)
                        .build());

        response.setAlternative(alternative);
        userResponseRepository.save(response);
    }

    @Transactional
    public UAttemptDTO finish(Long attemptId) {

        var user = context.getAuthenticatedUser();
        var attempt = uAttemptRepository.findByIdOrThrow(attemptId);

        attemptValidator.isUserAuth(user, attempt);
        attemptValidator.isActive(attempt);
        attemptValidator.isCompleted(attempt);

        var responses = userResponseRepository.findByAttemptId(attemptId);
        var result = scoreService.calculateResult(attempt, responses);

        attempt.finish(result);

        if (attempt.getUMission().getExecution().getStatus() == COMPLETED) {
            progressionService.unlockNextMission(user, attempt.getUMission().getMission());
        }

        levelService.findNextLevel(user.getLevel()).ifPresent(user::levelUp);

        return uAttemptMapper.toDTO(uAttemptRepository.save(attempt));
    }
}
