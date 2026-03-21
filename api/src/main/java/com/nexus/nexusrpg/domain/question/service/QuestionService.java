package com.nexus.nexusrpg.domain.question.service;

import com.nexus.nexusrpg.domain.question.controller.dto.QuestionDTO;
import com.nexus.nexusrpg.domain.question.mapper.QuestionMapper;
import com.nexus.nexusrpg.domain.question.model.Question;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.question.repository.QuestionRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.domain.mission.validator.MissionValidator;
import com.nexus.nexusrpg.domain.planet.validator.PlanetValidator;
import com.nexus.nexusrpg.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final AuthService authService;

    private final QuestionMapper questionMapper;

    private final QuestionRepository questionRepository;
    private final UserMissionRepository userMissionRepository;
    private final UserPlanetRepository userPlanetRepository;

    private final MissionValidator missionValidator;
    private final PlanetValidator planetValidator;

    public QuestionDTO getQuestion(Long questionId) {

        Long userId = authService.getAuthenticatedUser().getId();

        Question question = questionRepository.findByIdOrThrow(questionId);

        UserMission userMission = userMissionRepository.findByUserIdAndMissionIdOrThrow(userId, question.getMission().getId());
        UserPlanet userPlanet = userPlanetRepository.findByUserIdAndPlanetIdOrThrow(
                userId,
                userMission
                        .getMission()
                        .getPlanet()
                        .getId()
        );

        planetValidator.isAccessible(userPlanet);
        missionValidator.isAccessible(userMission);

        return questionMapper.toDTO(question);
    }
}
