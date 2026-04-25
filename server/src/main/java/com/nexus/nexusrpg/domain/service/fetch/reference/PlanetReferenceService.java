package com.nexus.nexusrpg.domain.service.fetch.reference;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.mapping.ProgressMapper;
import com.nexus.nexusrpg.domain.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.mapper.UPlanetMapper;
import com.nexus.nexusrpg.domain.mapper.reference.dynamics.PlanetDynamicReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.domain.repository.relation.UserPlanetRepository;
import org.springframework.stereotype.Component;

@Component
public class PlanetReferenceService extends ReferenceService<UPlanet, PlanetDTO>{

    public PlanetReferenceService(
            Context context,
            UserPlanetRepository repository,
            UPlanetMapper mapper,
            PlanetDynamicReferenceMapper referenceMapper,
            ProgressMapper progressMapper
    ) {

        super(
                context,
                repository,
                mapper,
                referenceMapper,
                progressMapper
        );
    }
}