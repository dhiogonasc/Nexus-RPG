package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.entity.alternative.repository.AlternativeRepository;
import com.nexus.nexusrpg.domain.entity.level.service.LevelService;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserResponseDTO;
import com.nexus.nexusrpg.domain.entity.mission.mapper.UserAttemptMapper;
import com.nexus.nexusrpg.domain.entity.mission.model.UserResponse;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserResponseRepository;
import com.nexus.nexusrpg.domain.entity.mission.validator.AttemptValidator;
import com.nexus.nexusrpg.domain.entity.mission.validator.MissionValidator;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserAttemptDTO;
import com.nexus.nexusrpg.domain.entity.mission.model.UserAttempt;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserAttemptRepository;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserMissionRepository;
import com.nexus.nexusrpg.domain.entity.question.repository.QuestionRepository;
import com.nexus.nexusrpg.domain.user.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static java.math.RoundingMode.HALF_UP;

@Service
@RequiredArgsConstructor
public class ExecuteMission {

    private final Context context;

    private final LevelService levelService;

    private final QuestionRepository questionRepository;
    private final AlternativeRepository alternativeRepository;

    private final UserMissionRepository userMissionRepository;
    private final UserResponseRepository userResponseRepository;
    private final UserAttemptRepository userAttemptRepository;
    private final UserAttemptMapper userAttemptMapper;

    private final UserValidator userValidator;
    private final MissionValidator missionValidator;
    private final AttemptValidator attemptValidator;

    @Transactional
    public UserAttemptDTO start(Long missionId) {

        var user = context.getAuthenticatedUser();
        var userMission = userMissionRepository.findByUserIdAndMissionIdOrThrow(user.getId(), missionId);

        missionValidator.isAccessible(userMission);
        attemptValidator.hasActiveAttempt(userMission);
        userValidator.hasEnoughOxygen(user);

        user.consumeOxygen();

        var attempt = UserAttempt.builder()
                .userMission(userMission)
                .startAt(LocalDateTime.now())
                .build();

        return userAttemptMapper.toDTO(userAttemptRepository.save(attempt));
    }

    @Transactional
    public void answer(Long attemptId, UserResponseDTO request) {
        var user = context.getAuthenticatedUser();
        var attempt = userAttemptRepository.findByIdOrThrow(attemptId);

        attemptValidator.isUserAuth(user, attempt);
        attemptValidator.isActive(attempt);

        var questionId = request.questionId();
        var question = questionRepository.findByIdOrThrow(questionId);

        var alternativeId = request.alternativeId();
        var alternative = alternativeRepository.findByIdOrThrow(alternativeId);

        attemptValidator.isAnswerValid(alternative, question);

        var response = userResponseRepository
                .findByAttemptIdAndQuestionId(attemptId, questionId)
                .orElseGet(() -> UserResponse.builder()
                        .attempt(attempt)
                        .question(question)
                        .build());

        response.setAlternative(alternative);
        userResponseRepository.save(response);
    }

    @Transactional
    public UserAttemptDTO finish(Long attemptId) {

        var user = context.getAuthenticatedUser();
        var attempt = userAttemptRepository.findByIdOrThrow(attemptId);

        attemptValidator.isUserAuth(user, attempt);
        attemptValidator.isActive(attempt);

        var responses = userResponseRepository.findByAttemptId(attemptId);
        var finalResult = calculateScore(attempt, responses);

        attempt.finish(finalResult);

        levelService
                .findNextLevel(user.getLevel())
                .ifPresent(user::levelUp);

        return userAttemptMapper.toDTO(userAttemptRepository.save(attempt));
    }

    private BigDecimal calculateScore(UserAttempt attempt, List<UserResponse> responses) {

        var totalQuestions = attempt.getUserMission().getMission().getQuestions().size();

        if (totalQuestions == 0) return BigDecimal.ZERO;

        var hits = responses.stream()
                .filter(UserResponse::isHit)
                .count();

        return BigDecimal.valueOf(hits)
                .divide(BigDecimal.valueOf(totalQuestions), 2, HALF_UP)
                .multiply(BigDecimal.valueOf(10));
    }
}
