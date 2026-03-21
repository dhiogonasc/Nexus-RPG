package com.nexus.nexusrpg.service;

import com.nexus.nexusrpg.controller.dto.user.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.controller.dto.global.planet.PlanetDTO;
import com.nexus.nexusrpg.controller.dto.user.planet.UserPlanetDTO;
import com.nexus.nexusrpg.controller.dto.user.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.mapper.UserMapper;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.model.relation.UserPlanet;
import com.nexus.nexusrpg.repository.UserPlanetRepository;
import com.nexus.nexusrpg.repository.UserRepository;
import com.nexus.nexusrpg.validator.PlanetValidator;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlanetService {

    private final AuthService authService;

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    private final UserPlanetRepository userPlanetRepository;

    private final PlanetValidator planetValidator;

    @Transactional(readOnly = true)
    public List<UserPlanetReferenceDTO> getPlanets() {
        String email = authService.getAuthenticatedEmail();

        return userRepository.findByEmailWithPlanets(email)
                .map(user -> user.getPlanets().stream()
                        .map(userMapper::toUserPlanetReferenceDTO)
                        .toList())
                .orElseThrow(() -> new BusinessException("User", "Usuário não encontrado", HttpStatus.NOT_FOUND));
    }


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
                userPlanet.planet().xpBonus(),
                planetMissions,
                userPlanet.planet().resource()
        );

        return new UserPlanetDTO(
                planet,
                userPlanet.status(),
                userPlanet.isAccessible(),
                userPlanet.progress()
        );
    }
}
