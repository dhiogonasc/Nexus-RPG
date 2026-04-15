package com.nexus.nexusrpg.domain.entity.mission.controller.dto;

import com.nexus.nexusrpg.domain.entity.planet.controller.dto.PlanetReferenceDTO;
import com.nexus.nexusrpg.domain.entity.mission.model.enums.MissionDifficulty;

public record MissionDTO(

        Long id,
        String name,
        String description,
        int order,
        MissionDifficulty difficulty,
        long xpBonus,
        PlanetReferenceDTO planet
){}
