package com.nexus.nexusrpg.common.dto;

import com.nexus.nexusrpg.common.enums.EntityStatus;

public record ExecutionDTO(
        EntityStatus status,
        boolean isCurrent
) {
}
