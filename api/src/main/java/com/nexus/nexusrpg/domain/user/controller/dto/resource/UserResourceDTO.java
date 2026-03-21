package com.nexus.nexusrpg.domain.user.controller.dto.resource;

import com.nexus.nexusrpg.domain.resource.controller.dto.ResourceDTO;

import java.time.LocalDateTime;

public record UserResourceDTO(

        ResourceDTO resource,
        boolean isCollected,
        LocalDateTime collectedAt
) {}