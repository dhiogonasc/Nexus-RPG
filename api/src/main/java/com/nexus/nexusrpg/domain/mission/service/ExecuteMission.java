package com.nexus.nexusrpg.domain.mission.service;

import com.nexus.nexusrpg.common.context.UserContext;
import com.nexus.nexusrpg.domain.mission.validator.AttemptValidator;
import com.nexus.nexusrpg.domain.mission.validator.MissionValidator;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionAttemptDTO;
import com.nexus.nexusrpg.domain.user.mapper.UserMapper;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserMissionAttempt;
import com.nexus.nexusrpg.domain.user.repository.relation.AttemptRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.user.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ExecuteMission {

    private final UserContext userContext;
    private final UserMissionRepository userMissionRepository;
    private final AttemptRepository attemptRepository;
    private final AttemptValidator attemptValidator;
    private final UserValidator userValidator;
    private final UserMapper userMapper;
    private final MissionValidator missionValidator;

    @Transactional
    public UserMissionAttemptDTO start(Long missionId) {

        User user = userContext.getAuthenticatedUser();
        updateOxygen(user);

        Long userId = user.getId();
        UserMission mission = userMissionRepository
                .findByUserIdAndMissionIdOrThrow(userId, missionId);

        missionValidator.isAccessible(mission);
        attemptValidator.hasActiveAttempt(missionId);

        UserMissionAttempt attempt = UserMissionAttempt
                .builder()
                .userMission(mission)
                .startAt(LocalDateTime.now())
                .build();

        return userMapper.toUserMissionAttemptDTO(attemptRepository.save(attempt));
    }

    @Transactional
    public UserMissionAttemptDTO finish(Long attemptId) {

        User user = userContext.getAuthenticatedUser();
        UserMissionAttempt attempt = attemptRepository.findByIdOrThrow(attemptId);

        attemptValidator.isUserAuth(user, attempt);
        attemptValidator.isActive(attempt);

        BigDecimal currentResult = BigDecimal.valueOf(10);
        attempt.setEndAt(LocalDateTime.now());
        attempt.setResult(currentResult);

        updateMission(attempt, currentResult);

        attemptRepository.save(attempt);

        return userMapper.toUserMissionAttemptDTO(attempt);
    }

    private void updateMission(UserMissionAttempt attempt, BigDecimal result) {

        UserMission um = attempt.getUserMission();
        BigDecimal bestResult = um.getBestResult();

        if (bestResult == null || result.compareTo(bestResult) > 0) {

            um.setBestResult(result);
        }
    }

    private void updateOxygen(User user) {

        userValidator.hasEnoughOxygen(user);
        user.consumeOxygen();
    }
}
