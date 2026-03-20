package com.nexus.nexusrpg.controller.dto.resource;

public record UserResourceReferenceDTO(

        ResourceReferenceDTO resource,
        boolean isCollected
) {}