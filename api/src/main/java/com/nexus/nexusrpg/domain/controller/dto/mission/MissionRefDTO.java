package com.nexus.nexusrpg.domain.controller.dto.mission;

public record MissionRefDTO(

        Long id,
        String name,

        UMExecutionRefDTO execution
) {}