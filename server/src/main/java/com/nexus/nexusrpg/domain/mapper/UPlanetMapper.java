package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.common.mapping.ExecutionMapper;
import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.mapper.task.UMissionTaskMapper;
import com.nexus.nexusrpg.domain.mapper.task.UResourceTaskMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UPlanetMapper implements Mapper<UPlanet, PlanetDTO> {

    private final ExecutionMapper<UPlanet> executionMapper;
    private final UMissionTaskMapper missionMapper;
    private final UResourceTaskMapper resourceMapper;

    @Override
    public PlanetDTO toDTO(UPlanet uPlanet){

        var planet = uPlanet.getPlanet();

        return new PlanetDTO(
                planet.getId(),
                planet.getName(),
                planet.getDescription(),
                planet.getXpBonus(),
                mapResources(uPlanet),
                mapMissions(uPlanet),
                executionMapper.map(uPlanet)
        );
    }

    private TaskDTO<EntityReferenceDTO> mapMissions(UPlanet uPlanet){

        var user  = uPlanet.getUser();
        var missions = uPlanet.getMissions();

        return missionMapper.map(user, missions);
    }

    private TaskDTO<EntityReferenceDTO> mapResources(UPlanet uPlanet){

        var user  = uPlanet.getUser();
        var resources = uPlanet.getResources();

        return resourceMapper.map(user, resources);
    }
}
