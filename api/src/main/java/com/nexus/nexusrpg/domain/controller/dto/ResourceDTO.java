package com.nexus.nexusrpg.domain.controller.dto;

public record ResourceDTO(

        Long id,
        String name,
        String description,
        int order,
        long xpBonus,

        URExecutionDTO execution
) {}