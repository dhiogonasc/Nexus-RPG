package com.nexus.nexusrpg.user.controller.dto;

import com.nexus.nexusrpg.common.dto.EntityStaticReference;
import com.nexus.nexusrpg.domain.controller.dto.LevelReference;

public record UserProgressionDTO(
        LevelReference level,
        EntityStaticReference planet,
        EntityStaticReference mission
) {
}
