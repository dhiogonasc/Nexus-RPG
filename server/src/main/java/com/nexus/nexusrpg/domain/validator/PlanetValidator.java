package com.nexus.nexusrpg.domain.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.domain.repository.relation.UserPlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.LOCKED;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
@RequiredArgsConstructor
public class PlanetValidator {

    private final UserPlanetRepository uPlanetRepository;

    public void isAccessible(UPlanet uPlanet) {
        if(uPlanet.getStatus() == LOCKED){
            throw new BusinessException(
                    "Planet",
                    "Bloqueado! Complete o planeta anterior!",
                    FORBIDDEN
            );
        }
    }

    public void isAccessibleByMission(UMission uMission) {

        var userId = uMission.getUser().getId();
        var planetId = uMission.getPlanet().getId();

        var userPlanet = uPlanetRepository.findByUserIdAndEntityId(userId, planetId);
        isAccessible(userPlanet);
    }
}
