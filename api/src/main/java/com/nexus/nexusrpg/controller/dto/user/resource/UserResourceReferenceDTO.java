package com.nexus.nexusrpg.controller.dto.user.resource;

import com.nexus.nexusrpg.controller.dto.global.resource.ResourceReferenceDTO;

public record UserResourceReferenceDTO(

        ResourceReferenceDTO resource,
        boolean isCollected
) {}