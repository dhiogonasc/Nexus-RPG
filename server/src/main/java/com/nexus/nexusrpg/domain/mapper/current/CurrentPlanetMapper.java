package com.nexus.nexusrpg.domain.mapper.current;

import com.nexus.nexusrpg.domain.mapper.reference.statics.StaticReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import org.springframework.stereotype.Component;

@Component
public class CurrentPlanetMapper extends CurrentMapper<UPlanet>{
    public CurrentPlanetMapper(StaticReferenceMapper<UPlanet> referenceMapper) {
        super(referenceMapper);
    }
}
