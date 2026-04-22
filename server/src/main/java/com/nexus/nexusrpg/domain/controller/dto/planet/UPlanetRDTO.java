package com.nexus.nexusrpg.domain.controller.dto.planet;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;
import com.nexus.nexusrpg.common.dto.Task;
import com.nexus.nexusrpg.common.enums.EntityStatus;
import com.nexus.nexusrpg.domain.model.enums.PlanetLabel;

public record UPlanetRDTO (
        Long id,
        PlanetLabel name,
        ExecutionDTO execution
) implements Task {

    @Override
    public EntityStatus getStatus() {
        return execution.status();
    }
}