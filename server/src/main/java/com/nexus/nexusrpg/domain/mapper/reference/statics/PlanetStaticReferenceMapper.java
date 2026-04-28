package com.nexus.nexusrpg.domain.mapper.reference.statics;

import com.nexus.nexusrpg.common.dto.EntityStaticReference;
import com.nexus.nexusrpg.common.mapper.StaticReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import org.springframework.stereotype.Component;

@Component
public class PlanetStaticReferenceMapper extends StaticReferenceMapper<UPlanet> {

    @Override
    public EntityStaticReference map(UPlanet uPlanet) {
        var planet = uPlanet.getPlanet();
        return new EntityStaticReference(
                planet.getId(),
                planet.getName().name(),
                planet.getDescription()
        );
    }
}
