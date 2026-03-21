package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.user.mission.UserMissionDTO;
import com.nexus.nexusrpg.controller.dto.user.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.user.UserMapper;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.validator.MissionValidator;
import com.nexus.nexusrpg.validator.PlanetValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MissionService {

    private final AuthService authService;

    private final UserMapper userMapper;

    private final UserMissionRepository userMissionRepository;
    private final UserPlanetRepository userPlanetRepository;

    private final MissionValidator missionValidator;
    private final PlanetValidator planetValidator;

    @Transactional(readOnly = true)
    public Page<UserMissionReferenceDTO> getMissions(Long planetId, Pageable pageable) {
        String email = authService.getAuthenticatedEmail();

        return userMissionRepository.findByEmailAndPlanet(email, planetId, pageable)
                .map(userMapper::toUserMissionReferenceDTO);
    }

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
}
