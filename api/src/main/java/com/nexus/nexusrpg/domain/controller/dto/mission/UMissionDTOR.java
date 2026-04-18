package com.nexus.nexusrpg.domain.controller.dto.mission;

public record UMissionDTOR(
        Long id,
        String name,
        UMissionExecDTOR execution
) {}