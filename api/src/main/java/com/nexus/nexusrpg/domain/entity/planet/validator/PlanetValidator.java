package com.nexus.nexusrpg.domain.entity.planet.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.entity.planet.repository.UserPlanetRepository;
import com.nexus.nexusrpg.domain.model.relation.UserMission;
import com.nexus.nexusrpg.domain.model.relation.UserPlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.LOCKED;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
@RequiredArgsConstructor
public class PlanetValidator {

    private final UserPlanetRepository userPlanetRepository;

    public void isAccessible(UserPlanet userPlanet) {

        var planetStatus =  userPlanet.getStatus();

        if(planetStatus == LOCKED){

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
