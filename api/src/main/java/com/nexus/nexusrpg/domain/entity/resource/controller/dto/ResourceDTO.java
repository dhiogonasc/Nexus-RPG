package com.nexus.nexusrpg.domain.entity.resource.controller.dto;

import com.nexus.nexusrpg.domain.entity.planet.controller.dto.PlanetReferenceDTO;

public record ResourceDTO(

        Long id,
        String name,
        String description,
        long xpBonus,
        PlanetReferenceDTO planet
) {
}
