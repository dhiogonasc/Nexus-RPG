package com.nexus.nexusrpg.domain.user.controller.dto.planet;

import com.nexus.nexusrpg.domain.planet.controller.dto.PlanetReferenceDTO;
import com.nexus.nexusrpg.common.entity.enums.EntityStatus;

import java.math.BigDecimal;

public record UserPlanetReferenceDTO(

        PlanetReferenceDTO planet,
        EntityStatus status,
        boolean isAccessible,
        boolean isCurrent,
        BigDecimal progress
) {}