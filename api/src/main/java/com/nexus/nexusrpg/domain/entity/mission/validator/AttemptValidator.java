package com.nexus.nexusrpg.domain.entity.mission.validator;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.entity.alternative.model.Alternative;
import com.nexus.nexusrpg.domain.entity.question.model.Question;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.domain.entity.mission.model.UserAttempt;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserAttemptRepository;
import com.nexus.nexusrpg.domain.model.relation.UserMission;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

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

    public void isAnswerValid(Alternative alternative, Question question) {

        if (!alternative.getQuestion().getId().equals(question.getId())) {
            throw new BusinessException("Attempt", "Alternativa inválida para esta questão", BAD_REQUEST);
        }
    }

    public void isCompleted(UserAttempt attempt) {

    }
}
