package com.nexus.nexusrpg.domain.entity.planet.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;
import com.nexus.nexusrpg.domain.mapper.UPlanetMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetRefMapper;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.repository.UPlanetRepository;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.entity.planet.validator.PlanetValidator;
import org.springframework.stereotype.Component;

@Component
public class GetPlanet extends GetEntity<
        Planet,
        com.nexus.nexusrpg.domain.model.relation.UPlanet,
        UPlanetDTO,
        UPlanetDTOR
        > {

    private final PlanetValidator validator;

    public GetPlanet(
            Context context,
            UPlanetRepository repository,
            UPlanetMapper mapper,
            UPlanetRefMapper refMapper,
            PlanetValidator validator
    ) {

        super(
                context,
                repository,
                mapper,
                refMapper
        );

        this.validator = validator;
    }

    @Override
    protected void validateAccess(com.nexus.nexusrpg.domain.model.relation.UPlanet uPlanet) {
        validator.isAccessible(uPlanet);
    }
}