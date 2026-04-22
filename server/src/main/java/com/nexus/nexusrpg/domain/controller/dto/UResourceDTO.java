package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;
import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;

public record UResourceDTO(
        Long id,
        String name,
        String description,
        long xpBonus,
        EntityReferenceDTO planet,
        ExecutionDTO execution
) {}