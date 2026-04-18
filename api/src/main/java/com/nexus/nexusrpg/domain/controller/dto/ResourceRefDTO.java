package com.nexus.nexusrpg.domain.controller.dto;

public record ResourceRefDTO(

        Long id,
        String name,

        URExecutionDTO execution
) {}