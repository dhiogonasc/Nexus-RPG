package com.nexus.nexusrpg.domain.planet.service;

import com.nexus.nexusrpg.common.service.GetEntity;
import com.nexus.nexusrpg.domain.user.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.domain.user.mapper.relation.UserPlanetMapper;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.common.service.UserContextService;
import com.nexus.nexusrpg.domain.planet.validator.PlanetValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPlanet extends GetEntity<UserPlanet, UserPlanetDTO, UserPlanetReferenceDTO> {

    private final UserPlanetRepository userPlanetRepository;
    private final UserPlanetMapper userPlanetMapper;
    private final PlanetValidator planetValidator;


    public GetPlanet(
            UserContextService userContextService,
            UserPlanetRepository userPlanetRepository,
            UserPlanetMapper userPlanetMapper,
            PlanetValidator planetValidator
    ) {
        super(userContextService);
        this.userPlanetRepository = userPlanetRepository;
        this.userPlanetMapper = userPlanetMapper;
        this.planetValidator = planetValidator;
    }

    @Override
    protected List<UserPlanet> findAll(Long userId) {
        return userPlanetRepository.findByUserId(userId);
    }

    @Override
    protected UserPlanet findById(Long userId, Long planetId) {
        return userPlanetRepository.findByUserIdAndPlanetIdOrThrow(userId, planetId);
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