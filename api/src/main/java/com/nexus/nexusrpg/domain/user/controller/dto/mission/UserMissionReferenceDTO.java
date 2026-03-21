package com.nexus.nexusrpg.domain.user.controller.dto.mission;

import com.nexus.nexusrpg.domain.mission.controller.dto.MissionReferenceDTO;
import com.nexus.nexusrpg.common.enums.EntityStatus;

import java.math.BigDecimal;

public record UserMissionReferenceDTO(

        MissionReferenceDTO mission,
        EntityStatus status,
        Boolean isAccessible,
        BigDecimal bestResult,
        BigDecimal progress
) {}