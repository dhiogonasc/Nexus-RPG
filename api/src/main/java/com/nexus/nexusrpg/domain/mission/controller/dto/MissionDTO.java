package com.nexus.nexusrpg.domain.mission.controller.dto;

import com.nexus.nexusrpg.domain.planet.controller.dto.PlanetReferenceDTO;
import com.nexus.nexusrpg.domain.mission.model.enums.MissionDifficulty;

public record MissionDTO(

        Long id,
        String name,
        String description,
        int order,
        MissionDifficulty difficulty,
        long xpBonus,
        PlanetReferenceDTO planet
){}
