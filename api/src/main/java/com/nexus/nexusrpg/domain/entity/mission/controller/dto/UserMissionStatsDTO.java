package com.nexus.nexusrpg.domain.entity.mission.controller.dto;

import com.nexus.nexusrpg.common.entity.enums.EntityStatus;

import java.math.BigDecimal;

public record UserMissionStatsDTO(

        EntityStatus status,
        Boolean isAccessible,
        Boolean isCurrent,
        BigDecimal bestResult,
        BigDecimal progress
) {
}
