package com.nexus.nexusrpg.domain.planet.controller.dto;

import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceReferenceDTO;

import java.util.List;

public record PlanetDTO(

        Long id,
        String name,
        String description,
        int order,
        long xpBonus,
        List<UserMissionReferenceDTO> missions,
        UserResourceReferenceDTO resource
) {}
