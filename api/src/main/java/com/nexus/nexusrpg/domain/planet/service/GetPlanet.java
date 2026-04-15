package com.nexus.nexusrpg.domain.planet.service;

import com.nexus.nexusrpg.common.entity.GetEntity;
import com.nexus.nexusrpg.domain.user.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.domain.user.mapper.relation.UserPlanetMapper;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.common.context.UserContext;
import com.nexus.nexusrpg.domain.planet.validator.PlanetValidator;
import org.springframework.stereotype.Service;

@Service
public class GetPlanet extends GetEntity<UserPlanet, UserPlanetDTO, UserPlanetReferenceDTO> {

    private final UserPlanetMapper userPlanetMapper;
    private final PlanetValidator planetValidator;


    public GetPlanet(
            UserContext userContext,
            UserPlanetRepository userPlanetRepository,
            UserPlanetMapper userPlanetMapper,
            PlanetValidator planetValidator
    ) {

        super(
                userContext,
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