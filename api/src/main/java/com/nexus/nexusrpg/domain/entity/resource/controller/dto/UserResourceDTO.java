package com.nexus.nexusrpg.domain.entity.resource.controller.dto;

public record UserResourceDTO(

        ResourceDTO resource,
        UserResourceStatsDTO stats
) {}