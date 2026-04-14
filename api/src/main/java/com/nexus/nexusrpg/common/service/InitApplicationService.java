package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.domain.level.service.LevelService;
import com.nexus.nexusrpg.domain.mission.service.MissionService;
import com.nexus.nexusrpg.domain.planet.service.PlanetService;
import com.nexus.nexusrpg.domain.resource.service.ResourceService;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitApplicationService {

    private final LevelService levelService;
    private final PlanetService planetService;
    private final MissionService missionService;
    private final ResourceService resourceService;

    public void initUser(User user) {

        var initialLevel = levelService.initialLevel(user);
        var initialPlanets = planetService.initialPlanets(user);
        var initialMissions = missionService.initialMissions(user);
        var initialResources = resourceService.initialResources(user);

        user.initialize(
                initialLevel,
                initialPlanets,
                initialMissions,
                initialResources
        );
    }
}
