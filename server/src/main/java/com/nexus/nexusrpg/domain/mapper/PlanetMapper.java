package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapper.ExecutionMapper;
import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.domain.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.mapper.task.MissionTaskMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlanetMapper implements Mapper<UPlanet, PlanetDTO> {

    private final ExecutionMapper<UPlanet> executionMapper;
    private final MissionTaskMapper missionMapper;

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
