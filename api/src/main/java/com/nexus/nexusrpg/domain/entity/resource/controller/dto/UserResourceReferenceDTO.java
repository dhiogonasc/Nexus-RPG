package com.nexus.nexusrpg.domain.entity.resource.controller.dto;

import java.time.LocalDateTime;

public record UserResourceReferenceDTO(

        ResourceReferenceDTO resource,
        boolean collected,
        LocalDateTime collectedAt
) {}