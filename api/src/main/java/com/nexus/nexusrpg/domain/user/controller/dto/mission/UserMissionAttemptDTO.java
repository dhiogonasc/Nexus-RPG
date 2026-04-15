package com.nexus.nexusrpg.domain.user.controller.dto.mission;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UserMissionAttemptDTO(

        Long id,
        UserMissionReferenceDTO userMission,
        LocalDateTime startAt,
        LocalDateTime endAt,
        BigDecimal result
) {}