package com.nexus.nexusrpg.domain.entity.planet.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.domain.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.controller.dto.PlanetRefDTO;
import com.nexus.nexusrpg.domain.model.UserPlanet;
import com.nexus.nexusrpg.domain.entity.planet.repository.UserPlanetRepository;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.entity.planet.validator.PlanetValidator;
import org.springframework.stereotype.Component;

import static com.nexus.nexusrpg.domain.mapper.PlanetMapper.toDTO;
import static com.nexus.nexusrpg.domain.mapper.PlanetMapper.toRefDTO;

@Component
public class GetPlanet extends GetEntity<UserPlanet, PlanetDTO, PlanetRefDTO> {

    private final PlanetValidator planetValidator;

    public GetPlanet(
            Context context,
            UserPlanetRepository userPlanetRepository,
            PlanetValidator planetValidator
    ) {

        super(
                context,
                "Planet",
                userPlanetRepository
        );

        this.planetValidator = planetValidator;
    }

    @Override
    protected PlanetDTO mapToDTO(UserPlanet userPlanet) {
        return toDTO(userPlanet);
    }

    @Override
    protected PlanetRefDTO mapToReferenceDTO(UserPlanet userPlanet) {
        return toRefDTO(userPlanet);
    }

    @Override
    protected void validateAccess(UserPlanet userPlanet) {
        planetValidator.isAccessible(userPlanet);
    }
}