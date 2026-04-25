package com.nexus.nexusrpg.user.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nexus.nexusrpg.common.dto.EntityStaticReference;
import com.nexus.nexusrpg.domain.controller.dto.LevelDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserProgressionDTO(
        LevelDTO level,
        EntityStaticReference planet,
        EntityStaticReference mission
) {
}
