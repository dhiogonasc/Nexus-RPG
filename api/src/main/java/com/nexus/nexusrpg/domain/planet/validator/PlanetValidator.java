package com.nexus.nexusrpg.domain.planet.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class PlanetValidator {
    public void isAccessible(UserPlanet userPlanet) {

        if(!userPlanet.getIsAccessible()){
            throw new BusinessException("Planet", "Bloqueado! Complete o planeta anterior!", HttpStatus.UNAUTHORIZED);
        }
    }
}
