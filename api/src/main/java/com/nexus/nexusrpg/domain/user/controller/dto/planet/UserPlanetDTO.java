package com.nexus.nexusrpg.domain.user.controller.dto.planet;

import com.nexus.nexusrpg.domain.planet.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.common.enums.EntityStatus;

import java.math.BigDecimal;

public record UserPlanetDTO(

        PlanetDTO planet,
        EntityStatus status,
        boolean isAccessible,
        boolean isCurrent,
        BigDecimal progress
) {}