package com.nexus.nexusrpg.domain.mission.service;

import com.nexus.nexusrpg.common.service.ProgressService;
import com.nexus.nexusrpg.common.service.UserContextService;
import com.nexus.nexusrpg.domain.mission.model.Mission;
import com.nexus.nexusrpg.domain.mission.repository.MissionRepository;
import com.nexus.nexusrpg.domain.mission.validator.AttemptValidator;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionAttemptDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.user.mapper.UserMapper;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserMissionAttempt;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.repository.relation.AttemptRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.domain.mission.validator.MissionValidator;
import com.nexus.nexusrpg.domain.planet.validator.PlanetValidator;
import com.nexus.nexusrpg.domain.user.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MissionService {

    private final BigDecimal AVG = BigDecimal.valueOf(7.00);

    private final UserContextService userContextService;
    private final ProgressService progressService;

    private final UserMapper userMapper;

    private final UserMissionRepository userMissionRepository;
    private final AttemptRepository attemptRepository;
    private final AttemptValidator attemptValidator;
    private final MissionRepository missionRepository;
    private final UserPlanetRepository userPlanetRepository;

    private final UserValidator userValidator;
    private final MissionValidator missionValidator;
    private final PlanetValidator planetValidator;

    @Transactional(readOnly = true)
    public Page<UserMissionReferenceDTO> getMissions(Long planetId, Pageable pageable) {

        var user = userContextService.getAuthenticatedUser();

        return userMissionRepository
                .findByUserIdAndPlanetId(user.getId(), planetId, pageable)
                .map(userMapper::toUserMissionReferenceDTO);
    }

    @Transactional(readOnly = true)
    public UserMissionDTO getMission(Long missionId) {

        Long userId = userContextService.getAuthenticatedUser().getId();
        UserMission userMission = userMissionRepository
                .findByUserIdAndMissionIdOrThrow(userId, missionId);

        UserPlanet userPlanet = userPlanetRepository
                .findByUserIdAndPlanetIdOrThrow(
                        userId,
                        userMission
                                .getMission()
                                .getPlanet()
                                .getId()
        );

        planetValidator.isAccessible(userPlanet);
        missionValidator.isAccessible(userMission);

        return userMapper.toUserMissionDTO(userMission);
    }

    @Transactional
    public UserMissionAttemptDTO start(Long missionId) {

        User user = userContextService.getAuthenticatedUser();
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

        User user = userContextService.getAuthenticatedUser();
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

            if (result.compareTo(AVG) > 0) {

                User user = um.getUser();
                Mission mission = um.getMission();

                progressService.completeMission(user, mission);
            }
        }
    }

    private void updateOxygen(User user) {

        userValidator.hasEnoughOxygen(user);
        user.consumeOxygen();
    }
}
