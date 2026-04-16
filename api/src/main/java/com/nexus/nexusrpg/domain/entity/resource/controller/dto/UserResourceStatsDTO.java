package com.nexus.nexusrpg.domain.entity.resource.controller.dto;

import com.nexus.nexusrpg.common.entity.enums.EntityStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UserResourceStatsDTO(

        EntityStatus status,
        boolean isAccessible,
        boolean isCurrent,
        BigDecimal progress,
        LocalDateTime collectedAt
) {
}
