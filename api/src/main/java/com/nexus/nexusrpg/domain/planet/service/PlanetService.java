package com.nexus.nexusrpg.domain.planet.service;

import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.planet.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.domain.user.mapper.UserMapper;
import com.nexus.nexusrpg.domain.user.mapper.relation.UserPlanetMapper;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.common.service.UserContextService;
import com.nexus.nexusrpg.domain.planet.validator.PlanetValidator;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlanetService {

    private final PlanetValidator planetValidator;

    private final UserPlanetRepository userPlanetRepository;
    private final UserPlanetMapper userPlanetMapper;

    private final UserContextService userContextService;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public List<UserPlanetReferenceDTO> getPlanets() {

        var userId = userContextService.getAuthenticatedUser().getId();

        return userPlanetRepository.findByUserId(userId).stream()
                .map(userPlanetMapper::toReferenceDTO)
                .toList();
    }


    public UserPlanetDTO getPlanet(Long planetId) {

        var user = userContextService.getAuthenticatedUser();

        var userPlanet = userPlanetRepository
                .findByUserIdAndPlanetIdOrThrow(user.getId(), planetId);

        planetValidator.isAccessible(userPlanet);

        UserPlanetDTO upDto = userPlanetMapper.toDTO(userPlanet);
        PlanetDTO pDto = upDto.planet();

        List<UserMissionReferenceDTO> planetMissions = user.getMissions().stream()
                .filter(um -> um.getMission().getPlanet().getId().equals(planetId))
                .map(userMapper::toUserMissionReferenceDTO)
                .toList();

        var planet = new PlanetDTO(
                pDto.id(),
                pDto.name(),
                pDto.description(),
                pDto.order(),
                pDto.xpBonus(),
                planetMissions,
                pDto.resource()
        );

        return new UserPlanetDTO(
                planet,
                upDto.status(),
                upDto.isAccessible(),
                upDto.isCurrent(),
                upDto.progress()
        );
    }
}
