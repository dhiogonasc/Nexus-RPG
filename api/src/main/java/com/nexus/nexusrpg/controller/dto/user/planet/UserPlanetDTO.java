package com.nexus.nexusrpg.controller.dto.user.planet;

import com.nexus.nexusrpg.controller.dto.global.planet.PlanetDTO;
import com.nexus.nexusrpg.model.enums.EntityStatus;

import java.math.BigDecimal;

public record UserPlanetDTO(

        PlanetDTO planet,
        EntityStatus status,
        boolean isAccessible,
        BigDecimal progress
) {}