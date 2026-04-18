package com.nexus.nexusrpg.domain.controller.dto.planet;

import com.nexus.nexusrpg.domain.model.enums.PlanetLabel;

public record PlanetDTO(

        Long id,
        PlanetLabel name,
        String description,
        int order,
        long xpBonus,

        UPExecutionDTO execution
) {}