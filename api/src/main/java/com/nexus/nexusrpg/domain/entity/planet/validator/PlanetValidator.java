package com.nexus.nexusrpg.domain.entity.planet.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.entity.planet.repository.UserPlanetRepository;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
@RequiredArgsConstructor
public class PlanetValidator {

    private final UserPlanetRepository userPlanetRepository;

    public void isAccessible(UserPlanet userPlanet) {

        if(!userPlanet.getIsAccessible()){

            throw new BusinessException(
                    "Planet",
                    "Bloqueado! Complete o planeta anterior!",
                    FORBIDDEN
            );
        }
    }

    public void isAccessibleByMission(UserMission userMission) {

        var userId = userMission.getUser().getId();
        var planetId = userMission.getMission().getPlanet().getId();
        var userPlanet = userPlanetRepository.findByUserIdAndPlanetIdOrThrow(userId, planetId);

        isAccessible(userPlanet);
    }
}
