package com.nexus.nexusrpg.domain.service;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.domain.controller.dto.attempt.request.AttemptAnswerRequestDTO;
import com.nexus.nexusrpg.domain.controller.dto.attempt.request.AttemptStartRequestDTO;
import com.nexus.nexusrpg.domain.controller.dto.attempt.response.AttemptResponseDTO;
import com.nexus.nexusrpg.domain.mapper.AnswerMapper;
import com.nexus.nexusrpg.domain.mapper.AttemptMapper;
import com.nexus.nexusrpg.domain.model.relation.Answer;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.AttemptRepository;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.service.progress.GlobalProgressService;
import com.nexus.nexusrpg.domain.validator.AttemptValidator;
import com.nexus.nexusrpg.domain.validator.MissionValidator;
import com.nexus.nexusrpg.user.model.User;
import com.nexus.nexusrpg.user.repository.UserRepository;
import com.nexus.nexusrpg.user.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttemptService {

    private final Context context;
    private final UserValidator userValidator;
    private final UserRepository userRepository;
    private final MissionValidator missionValidator;
    private final UserMissionRepository userMissionRepository;
    private final AttemptValidator attemptValidator;
    private final AttemptRepository attemptRepository;
    private final AttemptMapper attemptMapper;
    private final AnswerMapper answerMapper;
    private final GlobalProgressService progressService;

    @Transactional
    public AttemptResponseDTO start(AttemptStartRequestDTO request) {
        var user = userRepository
                .findByIdOrThrow(context.getAuthenticatedUser().getId());
        userValidator.hasEnoughOxygen(user);

        var uMission = getMission(user, request);
        var attempt = Attempt.builder()
                .uMission(uMission)
                .build();

        return attemptMapper.map(attemptRepository.save(attempt));
    }

    private UMission getMission(User user, AttemptStartRequestDTO request) {

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
    public AttemptResponseDTO finish(Long id, List<AttemptAnswerRequestDTO> request) {
        var attempt = attemptRepository.findByIdOrThrow(id);
        attemptValidator.isCurrent(attempt);

        var mission = attempt.getUMission().getMission();

        attemptValidator.validateAnswers(request, mission);
        attemptValidator.validateUniqueQuestions(request);

        var responses = createResponses(attempt, request);

        attempt.finish(responses);
        progressService.process(attempt);

        return attemptMapper.map(attemptRepository.save(attempt));
    }

    private List<Answer> createResponses(Attempt attempt, List<AttemptAnswerRequestDTO> request) {
        return request.stream()
                .map(r -> answerMapper.create(attempt, r.questionId(), r.alternativeId()))
                .toList();
    }
}
