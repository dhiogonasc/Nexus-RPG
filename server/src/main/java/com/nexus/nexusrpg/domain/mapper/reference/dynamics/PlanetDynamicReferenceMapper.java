package com.nexus.nexusrpg.domain.mapper.reference.dynamics;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.common.mapper.DynamicReferenceMapper;
import com.nexus.nexusrpg.common.mapper.ExecutionMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import org.springframework.stereotype.Component;

@Component
public class PlanetDynamicReferenceMapper extends DynamicReferenceMapper<UPlanet> {

    public PlanetDynamicReferenceMapper(ExecutionMapper<UPlanet> executionMapper) {
        super(executionMapper);
    }

    public EntityDynamicReference map(UPlanet uPlanet){
        var planet = uPlanet.getPlanet();
        return new EntityDynamicReference(
                planet.getId(),
                planet.getName().toString(),
                planet.getDescription(),
                planet.getOrder(),
                executionMapper.map(uPlanet)
        );
    }
}
