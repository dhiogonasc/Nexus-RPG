package com.nexus.nexusrpg.domain.entity.planet.controller.dto;

import com.nexus.nexusrpg.common.entity.enums.EntityStatus;
import java.math.BigDecimal;

public record UPExecutionDTO(

        EntityStatus status,
        boolean isAccessible,
        boolean isCurrent,
        BigDecimal progress
) {}