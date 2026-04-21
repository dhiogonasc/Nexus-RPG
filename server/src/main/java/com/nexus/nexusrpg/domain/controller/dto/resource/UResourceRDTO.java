package com.nexus.nexusrpg.domain.controller.dto.resource;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;

public record UResourceRDTO(
        Long id,
        String name,
        ExecutionDTO execution
) {}