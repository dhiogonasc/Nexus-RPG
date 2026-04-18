package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.entity.interfaces.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.mission.*;
import com.nexus.nexusrpg.domain.mapper.reference.PlanetRefMapper;
import com.nexus.nexusrpg.domain.model.relation.UserMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionMapper implements Mapper<UserMission, MissionDTO> {

    private final PlanetRefMapper planetRefMapper;

    public MissionDTO toDTO(UserMission um){

        var user =  um.getUser();
        var mission = um.getMission();

        var missionExecution = new UMExecutionDTO(
                um.getStatus(),
                um.isCurrent(),
                um.getResult()
        );

        var missionPlanet = planetRefMapper.map(user, mission.getPlanet());

        return new MissionDTO(
                mission.getId(),
                mission.getName(),
                mission.getDescription(),
                mission.getOrder(),
                mission.getXpBonus(),
                missionPlanet,
                missionExecution
        );
    }
}
