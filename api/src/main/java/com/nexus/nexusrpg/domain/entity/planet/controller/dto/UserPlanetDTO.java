package com.nexus.nexusrpg.domain.entity.planet.controller.dto;

import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionRefDTO;
import com.nexus.nexusrpg.domain.entity.resource.controller.dto.UserResourceRefDTO;

import java.util.List;

public record UserPlanetDTO(

        Long id,
        String name,
        String description,
        int order,
        long xpBonus,

        List<UserResourceRefDTO> resources,
        List<UserMissionRefDTO> missions,
        UPExecutionDTO execution
) {}