package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.mapper.UserMapper;
import com.nexus.nexusrpg.model.relation.UserMission;
import com.nexus.nexusrpg.repository.UserMissionRepository;
import com.nexus.nexusrpg.validator.MissionValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MissionService {

    private final AuthService authService;
    private final UserMissionRepository userMissionRepository;
    private final MissionValidator missionValidator;
    private final UserMapper userMapper;


    public UserMissionDTO getMission(Long missionId) {

        Long userId = authService.getAuthenticatedUser().getId();

        UserMission userMission = userMissionRepository.findByUserIdAndMissionIdOrThrow(userId, missionId);

        missionValidator.isAccessible(userMission);

        return userMapper.toUserMissionDTO(userMission);
    }
}
