package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.entity.interfaces.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.planet.PlanetDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPExecutionDTO;
import com.nexus.nexusrpg.domain.mapper.reference.MissionRefMapper;
import com.nexus.nexusrpg.domain.mapper.reference.ResourceRefMapper;
import com.nexus.nexusrpg.domain.model.relation.UserPlanet;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlanetMapper implements Mapper<UserPlanet, PlanetDTO> {

    private final ResourceRefMapper resourceRefMapper;
    private final MissionRefMapper missionRefMapper;

    public PlanetDTO toDTO(UserPlanet up){

        var user =  up.getUser();
        var planet = up.getPlanet();

        var planetResources = resourceRefMapper.map(user, planet.getResources());
        var planetMissions = missionRefMapper.map(user, planet.getMissions());

        var planetExecution = new UPExecutionDTO(
                up.getStatus(),
                up.isCurrent()
        );

        return new PlanetDTO(
                planet.getId(),
                planet.getName(),
                planet.getDescription(),
                planet.getOrder(),
                planet.getXpBonus(),
                planetResources,
                planetMissions,
                planetExecution
        );
    }
}
