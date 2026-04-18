package com.nexus.nexusrpg.domain.entity.planet.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.entity.planet.repository.UserPlanetRepository;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.LOCKED;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
@RequiredArgsConstructor
public class PlanetValidator {

    private final UserPlanetRepository userPlanetRepository;

    public void isAccessible(UPlanet uPlanet) {

        var planetStatus =  uPlanet.getStatus();

        if(planetStatus == LOCKED){

            throw new BusinessException(
                    "Planet",
                    "Bloqueado! Complete o planeta anterior!",
                    FORBIDDEN
            );
        }
    }

    public void isAccessibleByMission(UMission uMission) {

        var userId = uMission.getUser().getId();
        var planetId = uMission.getMission().getPlanet().getId();
        var userPlanet = userPlanetRepository.findByUserIdAndPlanetIdOrThrow(userId, planetId);

        isAccessible(userPlanet);
    }
}
