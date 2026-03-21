package com.nexus.nexusrpg.domain.mission.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class MissionValidator {
    public void isAccessible(UserMission userMission) {

        if(!userMission.getIsAccessible()){
            throw new BusinessException("Missão", "Bloqueado! Complete a missão anterior!", HttpStatus.UNAUTHORIZED);
        }
    }
}
