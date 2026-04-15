package com.nexus.nexusrpg.domain.entity.resource.controller.dto;

import java.time.LocalDateTime;

public record UserResourceDTO(

        ResourceDTO resource,
        boolean collected,
        LocalDateTime collectedAt
) {}