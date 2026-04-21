package com.nexus.nexusrpg.domain.controller.dto.resource;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;

public record UResourceDTOR(
        Long id,
        String name,
        ExecutionDTO execution
) {}