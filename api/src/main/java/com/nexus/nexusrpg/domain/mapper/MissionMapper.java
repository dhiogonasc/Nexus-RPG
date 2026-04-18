package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.domain.controller.dto.MissionDTO;
import com.nexus.nexusrpg.domain.controller.dto.MissionRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.UMExecutionDTO;
import com.nexus.nexusrpg.domain.controller.dto.UMExecutionRefDTO;
import com.nexus.nexusrpg.domain.model.UserMission;

public class MissionMapper {

    public static MissionDTO toDTO(UserMission um){

        var mission = um.getMission();

        var missionExecution = new UMExecutionDTO(
                um.getStatus(),
                um.isCurrent(),
                um.getResult()
        );

        return new MissionDTO(
                mission.getId(),
                mission.getName(),
                mission.getDescription(),
                mission.getOrder(),
                mission.getXpBonus(),
                missionExecution
        );
    }

    public static MissionRefDTO toRefDTO(UserMission um){

        var mission = um.getMission();
        var missionExecution = new UMExecutionRefDTO(um.getStatus());

        return new MissionRefDTO(
                mission.getId(),
                mission.getName(),
                missionExecution
        );
    }
}
