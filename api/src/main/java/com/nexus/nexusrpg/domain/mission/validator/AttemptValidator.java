package com.nexus.nexusrpg.domain.mission.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.model.relation.UserMissionAttempt;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class AttemptValidator {

    public void isActive(UserMissionAttempt attempt) {

        if(!isNull(attempt.getEndAt())){
            throw new BusinessException("Attempt", "Tentativa não iniciada ou já finalizada!", HttpStatus.BAD_REQUEST);
        }
    }
}
