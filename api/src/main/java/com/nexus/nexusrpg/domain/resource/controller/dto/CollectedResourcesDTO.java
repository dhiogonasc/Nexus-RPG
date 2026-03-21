package com.nexus.nexusrpg.domain.resource.controller.dto;

import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceReferenceDTO;

import java.math.BigDecimal;
import java.util.List;

public record CollectedResourcesDTO(

        List<UserResourceReferenceDTO> resources,
        BigDecimal progress
) {}
