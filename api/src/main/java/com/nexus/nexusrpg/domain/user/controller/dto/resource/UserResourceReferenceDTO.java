package com.nexus.nexusrpg.domain.user.controller.dto.resource;

import com.nexus.nexusrpg.domain.resource.controller.dto.ResourceReferenceDTO;

import java.time.LocalDateTime;

public record UserResourceReferenceDTO(

        ResourceReferenceDTO resource,
        boolean collected,
        LocalDateTime collectedAt
) {}