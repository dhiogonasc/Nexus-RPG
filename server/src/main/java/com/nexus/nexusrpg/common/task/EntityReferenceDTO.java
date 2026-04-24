package com.nexus.nexusrpg.common.task;

import com.nexus.nexusrpg.domain.model.enums.EntityStatus;

public record EntityReferenceDTO(
        Long id,
        String name,
        String description,
        int order,
        ExecutionDTO execution
) implements Task {
    @Override
    public EntityStatus status() {
        return this.execution.status();
    }
}
