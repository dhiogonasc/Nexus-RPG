package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.entity.interfaces.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceExecDTO;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetRefMapper;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UResourceMapper implements Mapper<UResource, UResourceDTO> {

    private final UPlanetRefMapper uPlanetRefMapper;

    public UResourceDTO toDTO(UResource uResource){

        var user = uResource.getUser();
        var resource = uResource.getResource();

        var planet = uPlanetRefMapper.map(user, resource.getPlanet());
        var execution = new UResourceExecDTO(uResource.getStatus());

        return new UResourceDTO(
                resource.getId(),
                resource.getName(),
                resource.getDescription(),
                resource.getOrder(),
                resource.getXpBonus(),
                planet,
                execution
        );
    }
}
