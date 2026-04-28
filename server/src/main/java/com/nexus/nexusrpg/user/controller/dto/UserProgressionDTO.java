package com.nexus.nexusrpg.user.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nexus.nexusrpg.common.dto.EntityStaticReference;
import com.nexus.nexusrpg.domain.controller.dto.level.LevelDetail;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserProgressionDTO(
        LevelDetail level,
        EntityStaticReference planet,
        EntityStaticReference mission
) {
}
