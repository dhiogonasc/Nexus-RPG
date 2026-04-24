package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.common.task.ExecutionDTO;
import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.domain.model.enums.PlanetLabel;

public record PlanetDTO(
        Long id,
        PlanetLabel name,
        String description,
        String content,
        long xpBonus,
        TaskDTO<EntityReferenceDTO> missions,
        ExecutionDTO execution,
        int order
) {}