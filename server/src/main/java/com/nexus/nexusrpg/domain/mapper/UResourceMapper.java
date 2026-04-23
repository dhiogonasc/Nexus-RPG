package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.common.mapping.ExecutionMapper;
import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.controller.dto.ResourceDTO;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UResourceMapper implements Mapper<UResource, ResourceDTO> {

    private final ExecutionMapper<UResource> executionMapper;
    private final UPlanetReferenceMapper uPlanetRefMapper;

    public ResourceDTO toDTO(UResource uResource){

        var resource = uResource.getResource();

        return new ResourceDTO(
                resource.getId(),
                resource.getName(),
                resource.getDescription(),
                resource.getXpBonus(),
                mapPlanet(uResource),
                executionMapper.map(uResource)
        );
    }

    public EntityReferenceDTO mapPlanet(UResource uResource){

        var user = uResource.getUser();
        var planet = uResource.getPlanet();

        return uPlanetRefMapper.map(user, planet);
    }
}
