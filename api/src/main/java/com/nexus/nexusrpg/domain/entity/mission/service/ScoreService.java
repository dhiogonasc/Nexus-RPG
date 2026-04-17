package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.domain.entity.mission.model.UserAttempt;
import com.nexus.nexusrpg.domain.entity.mission.model.UserResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

import static java.math.RoundingMode.HALF_UP;

@Component
public class ScoreService {

    public BigDecimal calculateResult(UserAttempt attempt, List<UserResponse> responses) {

        var totalQuestions = attempt.getUserMission().getMission().getQuestions().size();
        if (totalQuestions == 0) return BigDecimal.ZERO;

        var hits = responses.stream()
                .filter(UserResponse::isHit)
                .count();

        return BigDecimal.valueOf(hits)
                .divide(BigDecimal.valueOf(totalQuestions), 2, HALF_UP)
                .multiply(BigDecimal.valueOf(10));
    }
}
