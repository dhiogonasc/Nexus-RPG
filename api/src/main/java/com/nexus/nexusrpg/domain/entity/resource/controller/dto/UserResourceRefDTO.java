package com.nexus.nexusrpg.domain.entity.resource.controller.dto;

public record UserResourceRefDTO(

        Long id,
        String name,

        URExecutionRefDTO execution
) {}