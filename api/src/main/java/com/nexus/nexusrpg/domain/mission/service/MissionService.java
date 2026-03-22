package com.nexus.nexusrpg.domain.mission.service;

import com.nexus.nexusrpg.domain.mission.validator.AttemptValidator;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.user.mapper.UserMapper;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserMissionAttempt;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.repository.relation.AttemptRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.domain.auth.service.AuthService;
import com.nexus.nexusrpg.domain.mission.validator.MissionValidator;
import com.nexus.nexusrpg.domain.planet.validator.PlanetValidator;
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

    private final AuthService authService;

    private final UserMapper userMapper;

    private final UserMissionRepository userMissionRepository;
    private final AttemptRepository attemptRepository;
    private final AttemptValidator attemptValidator;
    private final UserPlanetRepository userPlanetRepository;

    private final MissionValidator missionValidator;
    private final PlanetValidator planetValidator;

    @Transactional(readOnly = true)
    public Page<UserMissionReferenceDTO> getMissions(Long planetId, Pageable pageable) {

        String email = authService.getAuthenticatedEmail();

        return userMissionRepository.findByEmailAndPlanet(email, planetId, pageable)
                .map(userMapper::toUserMissionReferenceDTO);
    }

    @Transactional(readOnly = true)
    public UserMissionDTO getMission(Long missionId) {

        Long userId = authService.getAuthenticatedUser().getId();

        UserMission userMission = userMissionRepository.findByUserIdAndMissionIdOrThrow(userId, missionId);

        UserPlanet userPlanet = userPlanetRepository.findByUserIdAndPlanetIdOrThrow(
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
    public void start(Long missionId) {

        UserMission userMission = getUserMission(missionId);

        missionValidator.isAccessible(userMission);

        UserMissionAttempt attempt = UserMissionAttempt.builder()
                .userMission(userMission)
                .startAt(LocalDateTime.now())
                .build();

        attemptRepository.save(attempt);
    }

    @Transactional
    public void finish(Long attemptId) {

        UserMissionAttempt attempt = attemptRepository.findByIdOrThrow(attemptId);

        attemptValidator.isActive(attempt);

        attempt.setEndAt(LocalDateTime.now());
        BigDecimal currentResult = BigDecimal.valueOf(10); // valor estático temporário
        attempt.setResult(currentResult);

        UserMission userMission = attempt.getUserMission();

        if(userMission.getBestResult() == null || currentResult.compareTo(userMission.getBestResult()) > 0) {
            userMission.setBestResult(currentResult);
        }

        attemptRepository.save(attempt);
        userMissionRepository.save(userMission);
    }

    private UserMission getUserMission(Long missionId) {

        Long userId = authService.getAuthenticatedUser().getId();

        return userMissionRepository.findByUserIdAndMissionIdOrThrow(userId, missionId);
    }
}
