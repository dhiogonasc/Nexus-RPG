package com.nexus.nexusrpg.domain.mapper.current;

import com.nexus.nexusrpg.domain.mapper.reference.ReferenceMapper;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import org.springframework.stereotype.Component;

@Component
public class CurrentPlanetMapper extends CurrentMapper<Planet, UPlanet>{
    public CurrentPlanetMapper(ReferenceMapper<Planet, UPlanet> referenceMapper) {
        super(referenceMapper);
    }
}
