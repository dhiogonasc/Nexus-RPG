package com.nexus.nexusrpg.controller.dto.global.resource;

import com.nexus.nexusrpg.controller.dto.user.resource.UserResourceReferenceDTO;

import java.math.BigDecimal;
import java.util.List;

public record CollectedResourcesDTO(

        List<UserResourceReferenceDTO> resources,
        BigDecimal progress
) {}
