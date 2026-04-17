package com.nexus.nexusrpg.domain.entity.mission.controller.dto;

import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UPExecutionRefDTO;

public record UserMissionRefDTO(

        Long id,
        String name,

        UPExecutionRefDTO execution
) {}