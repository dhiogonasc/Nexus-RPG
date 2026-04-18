package com.nexus.nexusrpg.domain.controller.dto.mission;

import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;

public record MissionDTO(

        Long id,
        String name,
        String description,
        int order,
        long xpBonus,
        UPlanetDTOR planet,
        UMExecutionDTO execution
) {}