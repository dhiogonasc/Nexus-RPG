package com.nexus.nexusrpg.controller.dto.planet;

import com.nexus.nexusrpg.model.enums.EntityStatus;

public record UserPlanetDTO(

        PlanetReferenceDTO planet,
        EntityStatus status,
        boolean isAccessible
) {}