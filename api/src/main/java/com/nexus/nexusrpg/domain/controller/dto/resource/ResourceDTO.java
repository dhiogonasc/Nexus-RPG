package com.nexus.nexusrpg.domain.controller.dto.resource;

import com.nexus.nexusrpg.domain.controller.dto.planet.PlanetRefDTO;

public record ResourceDTO(

        Long id,
        String name,
        String description,
        int order,
        long xpBonus,

        PlanetRefDTO planet,

        URExecutionDTO execution
) {}