package com.nexus.nexusrpg.domain.entity.planet.controller.dto;

public record UserPlanetReferenceDTO(

        Long id,
        String name,

        UPExecutionRefDTO execution
) {}