package com.nexus.nexusrpg.domain.controller.dto.mission;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;
import com.nexus.nexusrpg.common.dto.Task;
import com.nexus.nexusrpg.common.enums.EntityStatus;

public record UMissionRDTO(
        Long id,
        String name,
        ExecutionDTO execution
) implements Task {
    @Override
    public EntityStatus status() {
        return execution.status();
    }
}