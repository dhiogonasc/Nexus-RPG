package com.nexus.nexusrpg.domain.controller.dto.resource;

import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;

public record UResourceDTO(
        Long id,
        String name,
        String description,
        int order,
        long xpBonus,
        UPlanetDTOR planet,
        UResourceExecDTO execution
) {}