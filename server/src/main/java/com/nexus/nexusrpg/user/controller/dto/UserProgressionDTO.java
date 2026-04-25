package com.nexus.nexusrpg.user.controller.dto;

import com.nexus.nexusrpg.common.dto.EntityStaticReference;
import com.nexus.nexusrpg.domain.controller.dto.LevelDTO;

public record UserProgressionDTO(
        LevelDTO level,
        EntityStaticReference planet,
        EntityStaticReference mission
) {
}
