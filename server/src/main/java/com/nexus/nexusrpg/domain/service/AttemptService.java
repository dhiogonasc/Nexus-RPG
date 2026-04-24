package com.nexus.nexusrpg.domain.service;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.attempt.AttemptRequestDTO;
import com.nexus.nexusrpg.domain.controller.dto.attempt.AttemptResponseDTO;
import com.nexus.nexusrpg.domain.controller.dto.attempt.AttemptStartDTO;
import com.nexus.nexusrpg.domain.mapper.AttemptMapper;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import com.nexus.nexusrpg.domain.model.relation.Response;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.AlternativeRepository;
import com.nexus.nexusrpg.domain.repository.AttemptRepository;
import com.nexus.nexusrpg.domain.repository.QuestionRepository;
import com.nexus.nexusrpg.domain.repository.ResponseRepository;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.validator.AttemptValidator;
import com.nexus.nexusrpg.domain.validator.MissionValidator;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.user.repository.UserRepository;
import com.nexus.nexusrpg.user.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static java.math.RoundingMode.HALF_UP;

@Service
@RequiredArgsConstructor
public class AttemptService {

    private final Context context;
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;
    private final QuestionRepository questionRepository;
    private final AlternativeRepository alternativeRepository;
    private final AttemptRepository attemptRepository;
    private final ResponseRepository responseRepository;
    private final AttemptMapper attemptMapper;
    private final MissionValidator missionValidator;
    private final AttemptValidator attemptValidator;
    private final UserValidator userValidator;
    private final ProgressionService progressionService;

    @Transactional
    public AttemptResponseDTO start(AttemptStartDTO request) {

        var userId = context.getAuthenticatedUser().getId();
        var user = userRepository.findByIdOrThrow(userId);
        userValidator.hasEnoughOxygen(user);

        var mission = getMission(user, request);
        var attempt = Attempt.builder()
                .mission(mission)
                .build();

        user.consumeOxygen();
        userRepository.save(user);

        return attemptMapper.toDTO(attemptRepository.save(attempt));
    }

    private UMission getMission(User user, AttemptStartDTO request) {

        var mission = userMissionRepository
                .findByUserIdAndEntityId(
                        user.getId(),
                        request.missionId()
                );

        missionValidator.isAccessible(mission);
        attemptValidator.hasActiveAttempts(mission);

        return mission;
    }

    @Transactional
    public AttemptResponseDTO finish(Long id, List<AttemptRequestDTO> request) {

        var attempt =  attemptRepository.findByIdOrThrow(id);
        attemptValidator.isCurrent(attempt);

        var mission = attempt.getMission();
        var user = mission.getUser();
        user.addXp(mission.getMission().getXpBonus());
        userRepository.save(user);

        var responses = mapListResponse(attempt, request);
        attempt.getResponses().clear();
        attempt.getResponses().addAll(responses);

        var score = calculateScore(responses);
        attempt.setResult(score);

        mission.getExecution().updateBestResult(score);
        userMissionRepository.save(mission);

        if(score.compareTo(BigDecimal.valueOf(7))>=0){
            progressionService.unlockNextMission(user, mission.getMission());
        }

        attempt.setEndAt(LocalDateTime.now());

        return attemptMapper.toDTO(attemptRepository.save(attempt));
    }

    private List<Response> mapListResponse(Attempt attempt, List<AttemptRequestDTO> request) {
        return request.stream()
                .map(r -> mapResponse(attempt, r))
                .toList();
    }

    private Response mapResponse(Attempt attempt, AttemptRequestDTO request) {
        var question = questionRepository.findByIdOrThrow(request.questionId());
        var alternative = alternativeRepository.findByIdOrThrow(request.alternativeId());
        var response = Response.builder()
                .attempt(attempt)
                .question(question)
                .alternative(alternative)
                .build();
        return responseRepository.save(response);
    }

    private BigDecimal calculateScore(List<Response> responses) {
        if (responses.isEmpty()) return BigDecimal.ZERO;

        long correctCount = responses.stream()
                .filter(Response::isHit)
                .count();

        return BigDecimal.valueOf(correctCount)
                .multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(responses.size()), 2, HALF_UP);
    }
}
