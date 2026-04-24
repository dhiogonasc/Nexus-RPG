package com.nexus.nexusrpg.domain.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.AttemptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@Component
@RequiredArgsConstructor
public class AttemptValidator {

    private final AttemptRepository attemptRepository;

    public void hasActiveAttempts(UMission uMission) {

        var hasActiveAttempt = attemptRepository.existsByMissionIdAndEndAtIsNull(uMission.getId());

        if(hasActiveAttempt){
            throw new BusinessException(
                    "Attempt",
                    "Você já possui tentativas em curso para essa missão",
                    CONFLICT
            );
        }
    }

    public void isCurrent(Attempt attempt) {

        if(attempt.getEndAt() != null){
            throw new BusinessException(
                    "Attempt",
                    "Tentativa finalizada!",
                    BAD_REQUEST
            );
        }
    }
}
