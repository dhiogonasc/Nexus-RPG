package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.entity.interfaces.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.mission.*;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetRefMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionMapper implements Mapper<UMission, MissionDTO> {

    private final UPlanetRefMapper UPlanetRefMapper;

    public MissionDTO toDTO(UMission um){

        var user =  um.getUser();
        var mission = um.getMission();

        var missionExecution = new UMExecutionDTO(
                um.getStatus(),
                um.isCurrent(),
                um.getResult()
        );

        var missionPlanet = UPlanetRefMapper.map(user, mission.getPlanet());

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
