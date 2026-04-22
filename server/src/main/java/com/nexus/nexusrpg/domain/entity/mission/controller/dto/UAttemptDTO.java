package com.nexus.nexusrpg.domain.entity.mission.controller.dto;

import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UAttemptDTO(

        Long id,
        EntityReferenceDTO mission,
        LocalDateTime startAt,
        LocalDateTime endAt,
        BigDecimal result
) {}