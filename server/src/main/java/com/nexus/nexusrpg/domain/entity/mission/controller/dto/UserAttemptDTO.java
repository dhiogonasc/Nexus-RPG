package com.nexus.nexusrpg.domain.entity.mission.controller.dto;

import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionDTOR;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UserAttemptDTO(

        Long id,
        UMissionDTOR mission,
        LocalDateTime startAt,
        LocalDateTime endAt,
        BigDecimal result
) {}