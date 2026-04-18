package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.domain.controller.dto.resource.ResourceDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.URExecutionDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.ResourceRefDTO;
import com.nexus.nexusrpg.domain.model.relation.UserResource;

public class ResourceMapper {

    public static ResourceDTO toDTO(UserResource ur){

        var resource = ur.getResource();
        var resourceExecution = new URExecutionDTO(ur.getStatus());

        return new ResourceDTO(
                resource.getId(),
                resource.getName(),
                resource.getDescription(),
                resource.getOrder(),
                resource.getXpBonus(),
                resourceExecution
        );
    }

    public static ResourceRefDTO toRefDTO(UserResource ur){

        var resource = ur.getResource();
        var resourceExecution = new URExecutionDTO(ur.getStatus());

        return new ResourceRefDTO(
                resource.getId(),
                resource.getName(),
                resourceExecution
        );
    }
}
