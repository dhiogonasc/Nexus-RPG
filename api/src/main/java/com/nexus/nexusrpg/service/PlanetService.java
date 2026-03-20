package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.controller.dto.planet.PlanetDTO;
import com.nexus.nexusrpg.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.mapper.UserMapper;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.model.relation.UserPlanet;
import com.nexus.nexusrpg.repository.UserPlanetRepository;
import com.nexus.nexusrpg.validator.PlanetValidator;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlanetService {

    private final AuthService authService;
    private final UserPlanetRepository userPlanetRepository;
    private final PlanetValidator planetValidator;
    private final UserMapper userMapper;


    public UserPlanetDTO getPlanet(Long planetId) {

        User user = authService.getAuthenticatedUser();

        UserPlanet up = userPlanetRepository.findByUserIdAndPlanetIdOrThrow(user.getId(), planetId);
        planetValidator.isAccessible(up);

        UserPlanetDTO userPlanet = userMapper.toUserPlanetDTO(up);

        List<UserMissionReferenceDTO> planetMissions = user.getMissions().stream()
                .filter(um -> um.getMission().getPlanet().getId().equals(planetId))
                .map(userMapper::toUserMissionReferenceDTO)
                .toList();

        PlanetDTO planet = new PlanetDTO(
                userPlanet.planet().id(),
                userPlanet.planet().name(),
                userPlanet.planet().description(),
                userPlanet.planet().order(),
                planetMissions
        );

        return new UserPlanetDTO(
                planet,
                userPlanet.status(),
                userPlanet.isAccessible()
        );
    }
}
