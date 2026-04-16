package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.entity.mission.mapper.UserMissionMapper;
import com.nexus.nexusrpg.domain.entity.mission.model.UserMission;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserMissionRepository;
import com.nexus.nexusrpg.domain.entity.mission.validator.MissionValidator;
import org.springframework.stereotype.Service;

@Service
public class GetMission extends GetEntity<UserMission, UserMissionDTO, UserMissionReferenceDTO> {

    private final UserMissionMapper userMissionMapper;
    private final MissionValidator missionValidator;

    public GetMission(
            Context context,
            UserMissionRepository userMissionRepository,
            UserMissionMapper userMissionMapper,
            MissionValidator missionValidator
    ) {

        super(
                context,
                "Mission",
                userMissionRepository
        );

        this.userMissionMapper = userMissionMapper;
        this.missionValidator = missionValidator;
    }

    @Override
    protected UserMissionDTO mapToDTO(UserMission userMission) {
        return userMissionMapper.toDTO(userMission);
    }

    @Override
    protected UserMissionReferenceDTO mapToReferenceDTO(UserMission userMission) {
        return userMissionMapper.toReferenceDTO(userMission);
    }

    @Override
    protected void validateAccess(UserMission userMission) {
        missionValidator.isAccessible(userMission);
    }
}
