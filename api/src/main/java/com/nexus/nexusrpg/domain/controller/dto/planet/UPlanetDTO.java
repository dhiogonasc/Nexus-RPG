package com.nexus.nexusrpg.domain.controller.dto.planet;

import com.nexus.nexusrpg.domain.controller.dto.mission.MissionRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.ResourceRefDTO;
import com.nexus.nexusrpg.domain.model.enums.PlanetLabel;

import java.util.List;

public record UPlanetDTO(
        Long id,
        PlanetLabel name,
        String description,
        int order,
        long xpBonus,
        List<ResourceRefDTO> resources,
        List<MissionRefDTO> missions,
        UPlanetExecDTO execution
) {}