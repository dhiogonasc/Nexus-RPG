package com.nexus.nexusrpg.domain.entity.resource.controller.dto;

public record UserResourceReferenceDTO(

        ResourceReferenceDTO resource,
        UserResourceStatsDTO stats
) {}