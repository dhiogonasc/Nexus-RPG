package com.nexus.nexusrpg.domain.entity.planet.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetDTO;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.domain.entity.planet.mapper.UserPlanetMapper;
import com.nexus.nexusrpg.domain.entity.planet.model.UserPlanet;
import com.nexus.nexusrpg.domain.entity.planet.repository.UserPlanetRepository;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.entity.planet.validator.PlanetValidator;
import org.springframework.stereotype.Component;

@Component
public class GetPlanet extends GetEntity<UserPlanet, UserPlanetDTO, UserPlanetReferenceDTO> {

    private final UserPlanetMapper userPlanetMapper;
    private final PlanetValidator planetValidator;

    public GetPlanet(
            Context context,
            UserPlanetRepository userPlanetRepository,
            UserPlanetMapper userPlanetMapper,
            PlanetValidator planetValidator
    ) {

        super(
                context,
                "Planet",
                userPlanetRepository
        );

        this.userPlanetMapper = userPlanetMapper;
        this.planetValidator = planetValidator;
    }

    @Override
    protected UserPlanetDTO mapToDTO(UserPlanet userPlanet) {
        return userPlanetMapper.toDTO(userPlanet);
    }

    @Override
    protected UserPlanetReferenceDTO mapToReferenceDTO(UserPlanet userPlanet) {
        return userPlanetMapper.toReferenceDTO(userPlanet);
    }

    @Override
    protected void validateAccess(UserPlanet userPlanet) {
        planetValidator.isAccessible(userPlanet);
    }
}