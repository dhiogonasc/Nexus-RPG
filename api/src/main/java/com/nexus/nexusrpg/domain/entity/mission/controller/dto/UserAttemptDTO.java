package com.nexus.nexusrpg.domain.entity.mission.controller.dto;

import com.nexus.nexusrpg.domain.controller.dto.MissionRefDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UserAttemptDTO(

        Long id,
        MissionRefDTO userMission,
        LocalDateTime startAt,
        LocalDateTime endAt,
        BigDecimal result
) {}