package com.nexus.nexusrpg.domain.controller.dto.mission;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;

public record UMissionRDTO(
        Long id,
        String name,
        ExecutionDTO execution
) {}