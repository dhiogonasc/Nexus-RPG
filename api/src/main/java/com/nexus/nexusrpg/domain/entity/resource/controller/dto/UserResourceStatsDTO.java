package com.nexus.nexusrpg.domain.entity.resource.controller.dto;

import java.time.LocalDateTime;

public record UserResourceStatsDTO(

        boolean collected,
        LocalDateTime collectedAt
) {
}
