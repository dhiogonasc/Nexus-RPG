package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.entity.interfaces.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.resource.ResourceDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.URExecutionDTO;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetRefMapper;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResourceMapper implements Mapper<UResource, ResourceDTO> {

    private final UPlanetRefMapper UPlanetRefMapper;

    public ResourceDTO toDTO(UResource uResource){

        var user = uResource.getUser();
        var resource = uResource.getResource();

        var resourcePlanet = UPlanetRefMapper.map(user, resource.getPlanet());
        var resourceExecution = new URExecutionDTO(uResource.getStatus());

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
