package com.nexus.nexusrpg.domain.mapper.task;

import com.nexus.nexusrpg.common.mapper.ProgressMapper;
import com.nexus.nexusrpg.domain.mapper.reference.dynamics.PlanetDynamicReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import org.springframework.stereotype.Component;

@Component
public class PlanetTaskMapper extends TaskMapper<UPlanet> {

    public PlanetTaskMapper(
            PlanetDynamicReferenceMapper referenceMapper,
            ProgressMapper progressMapper) {
        super(referenceMapper, progressMapper);
    }
}
