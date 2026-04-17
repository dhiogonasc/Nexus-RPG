package com.nexus.nexusrpg.domain.entity.mission.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UserAttemptDTO(

        Long id,
        UserMissionRefDTO userMission,
        LocalDateTime startAt,
        LocalDateTime endAt,
        BigDecimal result
) {}