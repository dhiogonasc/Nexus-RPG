package com.nexus.nexusrpg.controller.dto.resource;

import java.math.BigDecimal;
import java.util.List;

public record CollectedResourcesDTO(

        List<UserResourceReferenceDTO> resources,
        BigDecimal progress
) {}
