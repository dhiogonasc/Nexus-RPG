package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.entity.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetExecDTO;
import com.nexus.nexusrpg.domain.entity.planet.service.PlanetProgress;
import com.nexus.nexusrpg.domain.mapper.reference.UMissionRefMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UResourceRefMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UPlanetMapper implements Mapper<UPlanet, UPlanetDTO> {

    private final UResourceRefMapper uResourceRefMapper;
    private final UMissionRefMapper uMissionRefMapper;
    private final PlanetProgress planetProgress;

    @Override
    public UPlanetDTO toDTO(UPlanet uPlanet){

        var user =  uPlanet.getUser();
        var planet = uPlanet.getPlanet();

        var resources = uResourceRefMapper
                .map(user, planet.getResources());
        var missions = uMissionRefMapper
                .map(user, planet.getMissions());

        var progress = planetProgress.calculate(uPlanet);
        var execution = new UPlanetExecDTO(
                uPlanet.getStatus(),
                uPlanet.isCurrent(),
                progress
        );

        return new UPlanetDTO(
                planet.getId(),
                planet.getName(),
                planet.getDescription(),
                planet.getOrder(),
                planet.getXpBonus(),
                resources,
                missions,
                execution
        );
    }
}
