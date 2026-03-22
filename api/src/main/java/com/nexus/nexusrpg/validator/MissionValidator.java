package com.nexus.nexusrpg.validator;

import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.model.relation.UserMission;
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
