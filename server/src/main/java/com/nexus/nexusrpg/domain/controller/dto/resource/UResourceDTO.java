package com.nexus.nexusrpg.domain.controller.dto.resource;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;

public record UResourceDTO(
        Long id,
        String name,
        String description,
        long xpBonus,
        UPlanetDTOR planet,
        ExecutionDTO execution
) {}