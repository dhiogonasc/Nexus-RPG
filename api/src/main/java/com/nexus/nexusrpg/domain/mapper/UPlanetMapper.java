package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.entity.interfaces.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetExecDTO;
import com.nexus.nexusrpg.domain.entity.planet.service.PlanetProgress;
import com.nexus.nexusrpg.domain.mapper.reference.MissionRefMapper;
import com.nexus.nexusrpg.domain.mapper.reference.ResourceRefMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UPlanetMapper implements Mapper<UPlanet, UPlanetDTO> {

    private final ResourceRefMapper resourceRefMapper;
    private final MissionRefMapper missionRefMapper;
    private final PlanetProgress planetProgress;

    @Override
    public UPlanetDTO toDTO(UPlanet uPlanet){

        var user =  uPlanet.getUser();
        var planet = uPlanet.getPlanet();

        var planetResources = resourceRefMapper.map(user, planet.getResources());
        var planetMissions = missionRefMapper.map(user, planet.getMissions());

        var uPlanetProgress = planetProgress.calculate(uPlanet);
        var uPlanetExecution = new UPlanetExecDTO(
                uPlanet.getStatus(),
                uPlanet.isCurrent(),
                uPlanetProgress
        );

        return new UPlanetDTO(
                planet.getId(),
                planet.getName(),
                planet.getDescription(),
                planet.getOrder(),
                planet.getXpBonus(),
                planetResources,
                planetMissions,
                uPlanetExecution
        );
    }
}
