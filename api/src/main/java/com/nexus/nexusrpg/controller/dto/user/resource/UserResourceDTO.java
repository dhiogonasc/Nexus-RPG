package com.nexus.nexusrpg.controller.dto.user.resource;

import com.nexus.nexusrpg.controller.dto.global.resource.ResourceDTO;

import java.time.LocalDateTime;

public record UserResourceDTO(

        ResourceDTO resource,
        boolean isCollected,
        LocalDateTime collectedAt
) {}