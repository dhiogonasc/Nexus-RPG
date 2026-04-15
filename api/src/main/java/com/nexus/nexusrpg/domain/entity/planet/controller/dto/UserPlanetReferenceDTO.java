package com.nexus.nexusrpg.domain.entity.planet.controller.dto;

import com.nexus.nexusrpg.common.entity.enums.EntityStatus;

import java.math.BigDecimal;

public record UserPlanetReferenceDTO(

        PlanetReferenceDTO planet,
        EntityStatus status,
        boolean isAccessible,
        boolean isCurrent,
        BigDecimal progress
) {}