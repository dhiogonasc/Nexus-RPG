package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.mapper.UserMapper;
import com.nexus.nexusrpg.model.relation.UserPlanet;
import com.nexus.nexusrpg.repository.UserPlanetRepository;
import com.nexus.nexusrpg.validator.PlanetValidator;
import lombok.*;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlanetService {

    private final AuthService authService;
    private final UserPlanetRepository userPlanetRepository;
    private final PlanetValidator planetValidator;
    private final UserMapper userMapper;


    public UserPlanetDTO getPlanet(Long planetId) {

        Long userId = authService.getAuthenticatedUser().getId();

        UserPlanet userPlanet = userPlanetRepository.findByUserIdAndPlanetIdOrThrow(userId, planetId);

        planetValidator.isAccessible(userPlanet);

        return userMapper.toUserPlanetDTO(userPlanet);
    }
}
