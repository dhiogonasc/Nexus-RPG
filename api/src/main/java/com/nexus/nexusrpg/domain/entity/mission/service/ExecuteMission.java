package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.entity.mission.mapper.UserAttemptMapper;
import com.nexus.nexusrpg.domain.entity.mission.validator.AttemptValidator;
import com.nexus.nexusrpg.domain.entity.mission.validator.MissionValidator;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserAttemptDTO;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserAttempt;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserAttemptRepository;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserMissionRepository;
import com.nexus.nexusrpg.domain.user.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ExecuteMission {

    private final Context context;
    private final UserMissionRepository userMissionRepository;
    private final UserAttemptRepository userAttemptRepository;
    private final UserAttemptMapper userAttemptMapper;
    private final UserValidator userValidator;
    private final MissionValidator missionValidator;
    private final AttemptValidator attemptValidator;

    @Transactional
    public UserAttemptDTO start(Long missionId) {

        var user = context.getAuthenticatedUser();
        Long userId = user.getId();

        var userMission = userMissionRepository
                .findByUserIdAndMissionIdOrThrow(userId, missionId);

        missionValidator.isAccessible(userMission);
        attemptValidator.hasActiveAttempt(userMission);

        updateOxygen(user);

        var attempt = UserAttempt.builder()
                .userMission(userMission)
                .startAt(LocalDateTime.now())
                .build();

        return userAttemptMapper.toDTO(userAttemptRepository.save(attempt));
    }

    @Transactional
    public UserAttemptDTO finish(Long attemptId) {

        User user = context.getAuthenticatedUser();
        UserAttempt attempt = userAttemptRepository.findByIdOrThrow(attemptId);

        attemptValidator.isUserAuth(user, attempt);
        attemptValidator.isActive(attempt);

        var currentResult = BigDecimal.valueOf(10);
        attempt.setEndAt(LocalDateTime.now());
        attempt.setResult(currentResult);

        updateMission(attempt, currentResult);

        return userAttemptMapper.toDTO(userAttemptRepository.save(attempt));
    }

    private void updateMission(UserAttempt attempt, BigDecimal result) {

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
