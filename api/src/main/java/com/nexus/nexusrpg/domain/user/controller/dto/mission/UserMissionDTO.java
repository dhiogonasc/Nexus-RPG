package com.nexus.nexusrpg.domain.user.controller.dto.mission;

import com.nexus.nexusrpg.domain.mission.controller.dto.MissionDTO;
import com.nexus.nexusrpg.common.enums.EntityStatus;

import java.math.BigDecimal;

public record UserMissionDTO(

        MissionDTO mission,
        EntityStatus status,
        Boolean isAccessible,
        BigDecimal bestResult,
        BigDecimal progress
) {}