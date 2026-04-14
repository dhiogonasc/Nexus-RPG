package com.nexus.nexusrpg.domain.planet.service;

import com.nexus.nexusrpg.domain.planet.repository.PlanetRepository;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.planet.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.mapper.UserMapper;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.domain.user.repository.entity.UserRepository;
import com.nexus.nexusrpg.domain.auth.service.AuthService;
import com.nexus.nexusrpg.domain.planet.validator.PlanetValidator;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.nexus.nexusrpg.common.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.common.enums.EntityStatus.UNLOCKED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class PlanetService {

    private final PlanetRepository planetRepository;
    private final UserPlanetRepository userPlanetRepository;

    private final AuthService authService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    private final PlanetValidator planetValidator;

    @Transactional(readOnly = true)
    public List<UserPlanetReferenceDTO> getPlanets() {

        var user = authService.getAuthenticatedUser();

        return userRepository.findByUserIdWithPlanets(user.getId())
                .map(u -> u.getPlanets().stream()
                        .map(userMapper::toUserPlanetReferenceDTO)
                        .toList())
                .orElseThrow(() -> new BusinessException("User", "Usuário não encontrado", NOT_FOUND));
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
                userPlanet.isCurrent(),
                userPlanet.progress()
        );
    }

    public List<UserPlanet> initialPlanets(User user){

        return planetRepository.findAll().stream()
                .map(p -> {
                    boolean isFirst = p.getId().equals(1L);
                    return UserPlanet.builder()
                            .user(user)
                            .planet(p)
                            .status(isFirst ? UNLOCKED : LOCKED)
                            .isAccessible(isFirst)
                            .isCurrent(isFirst)
                            .build();
                })
                .toList();
    }
}
