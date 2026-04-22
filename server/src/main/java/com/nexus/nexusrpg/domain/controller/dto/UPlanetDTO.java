package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;
import com.nexus.nexusrpg.common.dto.TaskDTO;
import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.model.enums.PlanetLabel;

public record UPlanetDTO(
        Long id,
        PlanetLabel name,
        String description,
        long xpBonus,
        TaskDTO<EntityReferenceDTO> resources,
        TaskDTO<EntityReferenceDTO> missions,
        ExecutionDTO execution
) {}