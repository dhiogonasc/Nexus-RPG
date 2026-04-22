package com.nexus.nexusrpg.domain.controller.dto.resource;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;
import com.nexus.nexusrpg.common.dto.Task;
import com.nexus.nexusrpg.common.enums.EntityStatus;

public record UResourceRDTO(
        Long id,
        String name,
        ExecutionDTO execution
) implements Task {
    @Override
    public EntityStatus getStatus() {
        return execution.status();
    }
}