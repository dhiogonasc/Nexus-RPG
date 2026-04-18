package com.nexus.nexusrpg.domain.controller.dto.mission;

import com.nexus.nexusrpg.domain.controller.dto.planet.PlanetRefDTO;

public record MissionDTO(

        Long id,
        String name,
        String description,
        int order,
        long xpBonus,
        PlanetRefDTO planet,
        UMExecutionDTO execution
) {}