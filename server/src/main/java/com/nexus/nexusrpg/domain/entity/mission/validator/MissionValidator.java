package com.nexus.nexusrpg.domain.entity.mission.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.entity.planet.validator.PlanetValidator;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.nexus.nexusrpg.common.enums.EntityStatus.LOCKED;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
@RequiredArgsConstructor
public class MissionValidator {

    private final PlanetValidator planetValidator;

    public void isAccessible(UMission uMission) {

        planetValidator.isAccessibleByMission(uMission);

        var missionStatus = uMission.getStatus();

        if(missionStatus == LOCKED){

            throw new BusinessException(
                    "Missão",
                    "Bloqueado! Complete a missão anterior!",
                    UNAUTHORIZED);
        }
    }
}
