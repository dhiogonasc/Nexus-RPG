package com.nexus.nexusrpg.domain.controller.dto.planet;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;
import com.nexus.nexusrpg.domain.model.enums.PlanetLabel;

public record UPlanetDTOR(
        Long id,
        PlanetLabel name,
        ExecutionDTO execution
) {}