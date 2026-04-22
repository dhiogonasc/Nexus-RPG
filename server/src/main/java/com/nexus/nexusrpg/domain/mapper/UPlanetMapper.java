package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.dto.TaskDTO;
import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.common.state.mapper.ExecutionMapper;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionRDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceRDTO;
import com.nexus.nexusrpg.domain.mapper.reference.UMissionReferenceMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UResourceReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UPlanetMapper implements
        Mapper<UPlanet, UPlanetDTO>,
        ExecutionMapper<UPlanet>
{

    private final UResourceReferenceMapper uResourceRefMapper;
    private final UMissionReferenceMapper uMissionRefMapper;

    @Override
    public UPlanetDTO toDTO(UPlanet uPlanet){

        var planet = uPlanet.getPlanet();

        return new UPlanetDTO(
                planet.getId(),
                planet.getName(),
                planet.getDescription(),
                planet.getXpBonus(),
                mapResources(uPlanet),
                mapMissions(uPlanet),
                mapExecution(uPlanet)
        );
    }

    private TaskDTO<UMissionRDTO> mapMissions(UPlanet uPlanet){

        var user  = uPlanet.getUser();
        var missions = uPlanet.getMissions();

        return uMissionRefMapper.mapTasks(user, missions);
    }

    private TaskDTO<UResourceRDTO> mapResources(UPlanet uPlanet){

        var user  = uPlanet.getUser();
        var resources = uPlanet.getResources();

        return uResourceRefMapper.mapTasks(user, resources);
    }
}
