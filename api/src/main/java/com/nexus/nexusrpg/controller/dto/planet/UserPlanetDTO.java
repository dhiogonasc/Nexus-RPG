package com.nexus.nexusrpg.controller.dto.planet;

import com.nexus.nexusrpg.controller.dto.resource.ResourceDTO;
import com.nexus.nexusrpg.model.enums.EntityStatus;

public record UserPlanetDTO(

        PlanetDTO planet,
        EntityStatus status,
        boolean isAccessible
) {}