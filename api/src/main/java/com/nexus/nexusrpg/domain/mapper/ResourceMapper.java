package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.entity.interfaces.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.resource.ResourceDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.URExecutionDTO;
import com.nexus.nexusrpg.domain.mapper.reference.PlanetRefMapper;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResourceMapper implements Mapper<UResource, ResourceDTO> {

    private final PlanetRefMapper planetRefMapper;

    public ResourceDTO toDTO(UResource ur){

        var user =  ur.getUser();
        var resource = ur.getResource();
        var resourceExecution = new URExecutionDTO(ur.getStatus());

        var resourcePlanet = planetRefMapper.map(user, resource.getPlanet());

        return new ResourceDTO(
                resource.getId(),
                resource.getName(),
                resource.getDescription(),
                resource.getOrder(),
                resource.getXpBonus(),
                resourcePlanet,
                resourceExecution
        );
    }
}
