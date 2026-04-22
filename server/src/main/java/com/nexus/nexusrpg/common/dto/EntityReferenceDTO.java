package com.nexus.nexusrpg.common.dto;

import com.nexus.nexusrpg.common.enums.EntityStatus;

public record EntityReferenceDTO(
        Long id,
        String name,
        ExecutionDTO execution
) implements Task {
    @Override
    public EntityStatus status() {
        return this.execution.status();
    }
}
