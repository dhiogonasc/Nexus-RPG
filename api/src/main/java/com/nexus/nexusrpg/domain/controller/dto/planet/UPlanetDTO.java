package com.nexus.nexusrpg.domain.controller.dto.planet;

import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionDTOR;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceDTOR;
import com.nexus.nexusrpg.domain.model.enums.PlanetLabel;

import java.util.List;

public record UPlanetDTO(
        Long id,
        PlanetLabel name,
        String description,
        int order,
        long xpBonus,
        List<UResourceDTOR> resources,
        List<UMissionDTOR> missions,
        UPlanetExecDTO execution
) {}