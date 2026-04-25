package com.nexus.nexusrpg.common.dto;

import com.nexus.nexusrpg.common.task.ExecutionDTO;
import com.nexus.nexusrpg.common.task.Task;
import com.nexus.nexusrpg.domain.model.enums.EntityStatus;

public record EntityDynamicReference(
        Long id,
        String name,
        String description,
        int order,
        ExecutionDTO execution
) implements DynamicReference, Task {
    @Override
    public EntityStatus status() {
        return this.execution.status();
    }
}
