package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.mapper.UserMapper;
import com.nexus.nexusrpg.model.relation.UserMission;
import com.nexus.nexusrpg.model.relation.UserPlanet;
import com.nexus.nexusrpg.repository.UserMissionRepository;
import com.nexus.nexusrpg.repository.UserPlanetRepository;
import com.nexus.nexusrpg.repository.UserRepository;
import com.nexus.nexusrpg.validator.MissionValidator;
import com.nexus.nexusrpg.validator.PlanetValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MissionService {

    private final AuthService authService;

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    private final UserMissionRepository userMissionRepository;
    private final UserPlanetRepository userPlanetRepository;

    private final MissionValidator missionValidator;
    private final PlanetValidator planetValidator;

    @Transactional(readOnly = true)
    public List<UserMissionReferenceDTO> getMissions() {
        String email = authService.getAuthenticatedEmail();

        return userRepository.findByEmailWithMissions(email)
                .map(user -> user.getMissions().stream()
                        .map(userMapper::toUserMissionReferenceDTO)
                        .toList())
                .orElseThrow(() -> new BusinessException("User", "Usuário não encontrado", HttpStatus.NOT_FOUND));
    }

    public UserMissionDTO getMission(Long missionId) {

        Long userId = authService.getAuthenticatedUser().getId();

        UserMission userMission = userMissionRepository.findByUserIdAndMissionIdOrThrow(userId, missionId);
        UserPlanet userPlanet = userPlanetRepository.findByUserIdAndPlanetIdOrThrow(userId, userMission.getMission().getPlanet().getId());

        planetValidator.isAccessible(userPlanet);
        missionValidator.isAccessible(userMission);

        return userMapper.toUserMissionDTO(userMission);
    }
}
