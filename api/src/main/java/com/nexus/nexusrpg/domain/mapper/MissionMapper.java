package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.domain.controller.dto.mission.MissionDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.MissionRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMExecutionDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMExecutionRefDTO;
import com.nexus.nexusrpg.domain.model.relation.UserMission;

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
