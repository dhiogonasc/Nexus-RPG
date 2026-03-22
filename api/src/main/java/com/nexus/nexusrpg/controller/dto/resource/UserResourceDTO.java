package com.nexus.nexusrpg.controller.dto.resource;

import java.time.LocalDateTime;

public record UserResourceDTO(

        ResourceDTO resource,
        boolean isCollected,
        LocalDateTime collectedAt
) {}