package com.nexus.nexusrpg.domain.controller.dto;

public record MissionRefDTO(

        Long id,
        String name,

        UMExecutionRefDTO execution
) {}