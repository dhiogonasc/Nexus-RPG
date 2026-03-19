package com.nexus.nexusrpg.controller.dto;

import com.nexus.nexusrpg.model.enums.EntityStatus;

public record UserPlanetDTO(

        PlanetDTO planet,
        EntityStatus status
) {}