package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.MissionDTO;
import com.nexus.nexusrpg.domain.controller.dto.MissionRefDTO;
import com.nexus.nexusrpg.domain.model.UserMission;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserMissionRepository;
import com.nexus.nexusrpg.domain.entity.mission.validator.MissionValidator;
import org.springframework.stereotype.Service;

import static com.nexus.nexusrpg.domain.mapper.MissionMapper.toDTO;
import static com.nexus.nexusrpg.domain.mapper.MissionMapper.toRefDTO;

@Service
public class GetMission extends GetEntity<UserMission, MissionDTO, MissionRefDTO> {

    private final MissionValidator missionValidator;

    public GetMission(
            Context context,
            UserMissionRepository userMissionRepository,
            MissionValidator missionValidator
    ) {

        super(
                context,
                "Mission",
                userMissionRepository
        );

        this.missionValidator = missionValidator;
    }

    @Override
    protected MissionDTO mapToDTO(UserMission userMission) {
        return toDTO(userMission);
    }

    @Override
    protected MissionRefDTO mapToReferenceDTO(UserMission userMission) {
        return toRefDTO(userMission);
    }

    @Override
    protected void validateAccess(UserMission userMission) {
        missionValidator.isAccessible(userMission);
    }
}
