package com.nexus.nexusrpg.domain.controller.dto;

import com.nexus.nexusrpg.common.entity.enums.EntityStatus;
import java.math.BigDecimal;

public record UPExecutionDTO(

        EntityStatus status,
        boolean isCurrent
) {}