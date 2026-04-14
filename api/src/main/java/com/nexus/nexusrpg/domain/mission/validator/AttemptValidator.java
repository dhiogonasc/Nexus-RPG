package com.nexus.nexusrpg.domain.mission.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMissionAttempt;
import com.nexus.nexusrpg.domain.user.repository.relation.AttemptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class AttemptValidator {

    private final AttemptRepository attemptRepository;

    public void hasActiveAttempt(Long userMissionId) {

        boolean hasActive = attemptRepository.existsByUserMissionIdAndEndAtIsNull(userMissionId);

        if (hasActive) {
            throw new BusinessException(
                    "Attempt",
                    "Você já tem uma tentativa em progresso para esta missão.",
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    public void isActive(UserMissionAttempt attempt) {

        if(!isNull(attempt.getEndAt())){

            throw new BusinessException(
                    "Attempt",
                    "Tentativa finalizada!",
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    public void isUserAuth(User user, UserMissionAttempt attempt) {

        Long currentUserId = user.getId();
        Long attemptUserId = attempt.getUserMission().getUser().getId();

        if(!currentUserId.equals(attemptUserId)){
            throw new BusinessException("Attempt", "Finalização proibida!", HttpStatus.UNAUTHORIZED);
        }
    }
}
