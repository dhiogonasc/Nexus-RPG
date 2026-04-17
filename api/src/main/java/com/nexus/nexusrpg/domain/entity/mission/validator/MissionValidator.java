package com.nexus.nexusrpg.domain.entity.mission.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.entity.planet.validator.PlanetValidator;
import com.nexus.nexusrpg.domain.entity.mission.model.UserMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
@RequiredArgsConstructor
public class MissionValidator {

    private final PlanetValidator planetValidator;

    public void isAccessible(UserMission userMission) {

        planetValidator.isAccessibleByMission(userMission);

        var missionStats = userMission.getExecution();

        if(!missionStats.getIsAccessible()){
            throw new BusinessException(
                    "Missão",
                    "Bloqueado! Complete a missão anterior!",
                    UNAUTHORIZED);
        }
    }
}
