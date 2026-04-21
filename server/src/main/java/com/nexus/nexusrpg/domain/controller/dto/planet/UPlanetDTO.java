package com.nexus.nexusrpg.domain.controller.dto.planet;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;
import com.nexus.nexusrpg.common.dto.ProgressionDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionRDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceRDTO;
import com.nexus.nexusrpg.domain.model.enums.PlanetLabel;

import java.util.List;

public record UPlanetDTO(
        Long id,
        PlanetLabel name,
        String description,
        long xpBonus,
        List<UResourceRDTO> resources,
        List<UMissionRDTO> missions,
        ExecutionDTO execution
) {}