package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.domain.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.controller.dto.PlanetRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.UPExecutionDTO;
import com.nexus.nexusrpg.domain.controller.dto.UPExecutionRefDTO;
import com.nexus.nexusrpg.domain.model.UserPlanet;

public class PlanetMapper {

    public static PlanetDTO toDTO(UserPlanet up){

        var planet = up.getPlanet();

        var planetResources = planet.getResources();
        var planetMissions = planet.getMissions();

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
                planetExecution
        );
    }

    public static PlanetRefDTO toRefDTO(UserPlanet up){

        var planet = up.getPlanet();

        var planetExecution = new UPExecutionRefDTO(up.getStatus());

        return new PlanetRefDTO(
                planet.getId(),
                planet.getName(),
                planetExecution
        );
    }
}
