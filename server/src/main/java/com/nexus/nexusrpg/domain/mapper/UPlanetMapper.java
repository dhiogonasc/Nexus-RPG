package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.dto.ProgressionDTO;
import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.common.state.mapper.ExecutionMapper;
import com.nexus.nexusrpg.common.state.mapper.ProgressionMapper;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionRDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceRDTO;
import com.nexus.nexusrpg.domain.entity.planet.service.CountPlanet;
import com.nexus.nexusrpg.domain.mapper.reference.UMissionRefMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UResourceRefMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UPlanetMapper implements
        Mapper<UPlanet, UPlanetDTO>,
        ExecutionMapper<UPlanet>
{

    private final CountPlanet countPlanet;
    private final UResourceRefMapper uResourceRefMapper;
    private final UMissionRefMapper uMissionRefMapper;

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

    private List<UMissionRDTO> mapMissions(UPlanet uPlanet){

        var user  = uPlanet.getUser();
        var missions = uPlanet.getMissions();

        return uMissionRefMapper.map(user, missions);
    }

    private List<UResourceRDTO> mapResources(UPlanet uPlanet){

        var user  = uPlanet.getUser();
        var resources = uPlanet.getResources();

        return uResourceRefMapper.map(user, resources);
    }
}
