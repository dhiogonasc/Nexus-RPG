package com.nexus.nexusrpg.common.dto;

public record EntityStaticReference(
        Long id,
        String name,
        String description
) implements StaticReference {}
