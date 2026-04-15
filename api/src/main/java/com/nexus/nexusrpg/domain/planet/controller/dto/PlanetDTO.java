package com.nexus.nexusrpg.domain.planet.controller.dto;

import com.nexus.nexusrpg.domain.mission.controller.dto.MissionReferenceDTO;
import com.nexus.nexusrpg.domain.resource.controller.dto.ResourceReferenceDTO;

import java.util.List;

public record PlanetDTO(

        Long id,
        String name,
        String description,
        int order,
        long xpBonus,
        List<ResourceReferenceDTO> resources,
        List<MissionReferenceDTO> missions
) {}
