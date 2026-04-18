package com.nexus.nexusrpg.domain.controller.dto.mission;

import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;

public record UMissionDTO(
        Long id,
        String name,
        String description,
        int order,
        long xpBonus,
        UPlanetDTOR planet,
        UMissionExecDTO execution
) {}