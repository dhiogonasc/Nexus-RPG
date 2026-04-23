package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.common.task.ExecutionDTO;
import com.nexus.nexusrpg.common.task.EntityReferenceDTO;

public record ResourceDTO(
        Long id,
        String name,
        String description,
        long xpBonus,
        EntityReferenceDTO planet,
        ExecutionDTO execution
) {}