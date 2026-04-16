package com.nexus.nexusrpg.domain.entity.mission.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.entity.mission.model.UserAttempt;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserAttemptRepository;
import com.nexus.nexusrpg.domain.entity.mission.model.UserMission;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class AttemptValidator {

    private final UserAttemptRepository userAttemptRepository;

    public void hasActiveAttempt(UserMission mission) {

        boolean hasActive = userAttemptRepository.existsByUserMissionIdAndEndAtIsNull(mission.getId());

        if (hasActive) {

            throw new BusinessException(
                    "Attempt",
                    "Você já tem uma tentativa em progresso para esta missão.",
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    public void isActive(UserAttempt attempt) {

        if(!isNull(attempt.getEndAt())){

            throw new BusinessException(
                    "Attempt",
                    "Tentativa finalizada!",
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    public void isUserAuth(User user, UserAttempt attempt) {

        Long currentUserId = user.getId();
        Long attemptUserId = attempt.getUserMission().getUser().getId();

        if(!currentUserId.equals(attemptUserId)){
            throw new BusinessException("Attempt", "Finalização proibida!", HttpStatus.UNAUTHORIZED);
        }
    }
}
