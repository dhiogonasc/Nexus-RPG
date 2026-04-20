package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.entity.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.mission.*;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetRefMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UMissionMapper implements Mapper<UMission, UMissionDTO> {

    private final UPlanetRefMapper uPlanetRefMapper;

    public UMissionDTO toDTO(UMission uMission){

        var user =  uMission.getUser();
        var mission = uMission.getMission();

        var planet = uPlanetRefMapper.map(user, mission.getPlanet());
        var execution = new UMissionExecDTO(
                uMission.getStatus(),
                uMission.isCurrent(),
                uMission.getResult()
        );

        return new UMissionDTO(
                mission.getId(),
                mission.getName(),
                mission.getDescription(),
                mission.getOrder(),
                mission.getXpBonus(),
                planet,
                execution
        );
    }
}
