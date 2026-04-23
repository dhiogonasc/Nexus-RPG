package com.nexus.nexusrpg.common.dto;

import com.nexus.nexusrpg.domain.model.enums.EntityStatus;

public record ExecutionDTO(
        EntityStatus status,
        boolean isCurrent
) {
}
