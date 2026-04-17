package com.nexus.nexusrpg.domain.entity.resource.controller.dto;

import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetReferenceDTO;

public record UserResourceDTO(

        Long id,
        String name,
        String description,
        long xpBonus,

        UserPlanetReferenceDTO planet,
        URExecutionDTO execution
) {}