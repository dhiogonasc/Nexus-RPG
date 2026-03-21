package com.nexus.nexusrpg.controller.dto.user.mission;

import com.nexus.nexusrpg.controller.dto.global.mission.MissionReferenceDTO;
import com.nexus.nexusrpg.model.enums.EntityStatus;

import java.math.BigDecimal;

public record UserMissionReferenceDTO(

        MissionReferenceDTO mission,
        EntityStatus status,
        Boolean isAccessible,
        BigDecimal bestResult,
        BigDecimal progress
) {}