package com.nexus.nexusrpg.domain.controller.dto.resource;

public record ResourceRefDTO(

        Long id,
        String name,

        URExecutionDTO execution
) {}