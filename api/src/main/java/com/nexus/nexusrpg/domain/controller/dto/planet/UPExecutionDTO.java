package com.nexus.nexusrpg.domain.controller.dto.planet;

import com.nexus.nexusrpg.common.entity.dto.ProgressDTO;
import com.nexus.nexusrpg.common.entity.enums.EntityStatus;

public record UPExecutionDTO(

        EntityStatus status,
        boolean isCurrent,
        ProgressDTO progress
) {}