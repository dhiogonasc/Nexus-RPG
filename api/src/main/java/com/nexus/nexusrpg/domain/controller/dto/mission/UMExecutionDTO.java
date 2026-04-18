package com.nexus.nexusrpg.domain.controller.dto.mission;

import com.nexus.nexusrpg.common.entity.enums.EntityStatus;

import java.math.BigDecimal;

public record UMExecutionDTO(

        EntityStatus status,
        Boolean isCurrent,
        BigDecimal bestResult
) {
}
