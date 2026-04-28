package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapper.ExecutionMapper;
import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.domain.controller.dto.PlanetDetail;
import com.nexus.nexusrpg.domain.mapper.task.MissionTaskMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlanetMapper implements Mapper<UPlanet, PlanetDetail> {

    private final ExecutionMapper<UPlanet> executionMapper;
    private final MissionTaskMapper missionMapper;

    @Override
    public PlanetDetail map(UPlanet uPlanet){

        var planet = uPlanet.getPlanet();

        return PlanetDetail.builder()
                .id(planet.getId())
                .name(planet.getName().toString())
                .description(planet.getDescription())
                .order(planet.getOrder())
                .execution(executionMapper.map(uPlanet))
                .xpBonus(planet.getXpBonus())
                .content(planet.getContent())
                .missions(mapMissions(uPlanet))
                .build();
    }

    private TaskDTO mapMissions(UPlanet uPlanet){
        var missions = uPlanet.getUMissions();
        return missionMapper.map(missions);
    }
}
