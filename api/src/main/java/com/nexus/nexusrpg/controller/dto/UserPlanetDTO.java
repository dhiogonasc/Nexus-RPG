package com.nexus.nexusrpg.controller.dto;

import com.nexus.nexusrpg.controller.dto.planet.PlanetReferenceDTO;
import com.nexus.nexusrpg.model.enums.EntityStatus;

public record UserPlanetDTO(

        PlanetReferenceDTO planet,
        EntityStatus status
) {}