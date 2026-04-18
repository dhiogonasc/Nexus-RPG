package com.nexus.nexusrpg.domain.entity.planet.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.domain.controller.dto.planet.PlanetDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.PlanetRefDTO;
import com.nexus.nexusrpg.domain.mapper.PlanetMapper;
import com.nexus.nexusrpg.domain.mapper.reference.PlanetRefMapper;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.entity.planet.repository.UserPlanetRepository;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.entity.planet.validator.PlanetValidator;
import org.springframework.stereotype.Component;

@Component
public class GetPlanet extends GetEntity<
        Planet,
        UserPlanet,
        PlanetDTO,
        PlanetRefDTO
        > {

    private final PlanetValidator validator;

    public GetPlanet(
            Context context,
            UserPlanetRepository repository,
            PlanetMapper mapper,
            PlanetRefMapper refMapper,
            PlanetValidator validator
    ) {

        super(
                context,
                "Planet",
                repository,
                mapper,
                refMapper
        );

        this.validator = validator;
    }

    @Override
    protected void validateAccess(UserPlanet userPlanet) {
        validator.isAccessible(userPlanet);
    }
}