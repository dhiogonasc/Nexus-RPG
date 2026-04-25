package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapping.ExecutionMapper;
import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.domain.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.mapper.task.UMissionTaskMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UPlanetMapper implements Mapper<UPlanet, PlanetDTO> {

    private final ExecutionMapper<UPlanet> executionMapper;
    private final UMissionTaskMapper missionMapper;

    @Override
    public PlanetDTO map(UPlanet uPlanet){

        var planet = uPlanet.getPlanet();

        return new PlanetDTO(
                planet.getId(),
                planet.getName(),
                planet.getDescription(),
                planet.getContent(),
                planet.getXpBonus(),
                mapMissions(uPlanet),
                executionMapper.map(uPlanet),
                planet.getOrder()
        );
    }

    private TaskDTO mapMissions(UPlanet uPlanet){
        var missions = uPlanet.getUMissions();
        return missionMapper.map(missions);
    }
}
