package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.common.mapping.mapper.ExecutionMapper;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetRDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceDTO;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UResourceMapper implements Mapper<UResource, UResourceDTO> {

    private final ExecutionMapper<UResource> executionMapper;
    private final UPlanetReferenceMapper uPlanetRefMapper;

    public UResourceDTO toDTO(UResource uResource){

        var resource = uResource.getResource();

        return new UResourceDTO(
                resource.getId(),
                resource.getName(),
                resource.getDescription(),
                resource.getXpBonus(),
                mapPlanet(uResource),
                executionMapper.map(uResource)
        );
    }

    public UPlanetRDTO mapPlanet(UResource uResource){

        var user = uResource.getUser();
        var planet = uResource.getPlanet();

        return uPlanetRefMapper.mapReference(user, planet);
    }
}
