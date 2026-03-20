package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.mapper.UserMapper;
import com.nexus.nexusrpg.repository.UserPlanetRepository;
import lombok.*;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlanetService {

    private final AuthService authService;
    private final UserPlanetRepository userPlanetRepository;
    private final UserMapper userMapper;


    public UserPlanetDTO getPlanet(Long id) {

        Long myId = authService.getAuthenticatedUser().getId();

        return userMapper.toUserPlanetDTO(userPlanetRepository.findByUserIdAndPlanetIdOrThrow(myId, id));
    }
}
