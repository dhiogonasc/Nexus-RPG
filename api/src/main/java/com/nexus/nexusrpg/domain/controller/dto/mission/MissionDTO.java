package com.nexus.nexusrpg.domain.controller.dto.mission;

public record MissionDTO(

        Long id,
        String name,
        String description,
        int order,
        long xpBonus,

        UMExecutionDTO execution
) {}