package com.nexus.nexusrpg.controller.dto;

import com.nexus.nexusrpg.model.enums.EntityStatus;

import java.math.BigDecimal;

public record UserMissionDTO(

        MissionDTO mission,
        EntityStatus status,
        BigDecimal bestResult
) {}