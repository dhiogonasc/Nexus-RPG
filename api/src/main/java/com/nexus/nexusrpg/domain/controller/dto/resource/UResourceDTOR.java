package com.nexus.nexusrpg.domain.controller.dto.resource;

public record UResourceDTOR(
        Long id,
        String name,
        UResourceExecDTO execution
) {}