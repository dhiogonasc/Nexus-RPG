package com.nexus.nexusrpg.domain.entity.mission.controller.dto;

import com.nexus.nexusrpg.domain.entity.mission.model.enums.MissionDifficulty;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetReferenceDTO;

public record UserMissionDTO(

        Long id,
        String name,
        String description,
        int order,
        long xpBonus,
        MissionDifficulty difficulty,
        UserPlanetReferenceDTO planet,
        URExecutionDTO execution
) {}