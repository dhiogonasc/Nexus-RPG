package com.nexus.nexusrpg.common.task;

import com.nexus.nexusrpg.domain.model.enums.EntityStatus;

public record ExecutionDTO(
        EntityStatus status,
        boolean isCurrent
) {
}
