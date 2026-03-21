package com.nexus.nexusrpg.domain.user.controller.dto.resource;

import com.nexus.nexusrpg.domain.resource.controller.dto.ResourceReferenceDTO;

public record UserResourceReferenceDTO(

        ResourceReferenceDTO resource,
        boolean isCollected
) {}