package com.nexus.nexusrpg.user.controller.dto;

import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.controller.dto.LevelDTO;

public record UserProgressionDTO(
        LevelDTO level,
        EntityReferenceDTO planet,
        EntityReferenceDTO mission,
        EntityReferenceDTO resource
) {
}
