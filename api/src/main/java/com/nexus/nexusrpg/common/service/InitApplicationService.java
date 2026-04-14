package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.domain.level.model.Level;
import com.nexus.nexusrpg.domain.level.service.LevelService;
import com.nexus.nexusrpg.domain.mission.service.InitMissionService;
import com.nexus.nexusrpg.domain.planet.service.InitPlanetService;
import com.nexus.nexusrpg.domain.resource.service.InitResourceService;
import com.nexus.nexusrpg.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitApplicationService {

    private final LevelService levelService;

    private final InitPlanetService initPlanetService;
    private final InitMissionService initMissionService;
    private final InitResourceService initResourceService;

    public void initUser(User user) {

        var initialPlanets = initPlanetService.initialize(user);
        var initialMissions = initMissionService.initialize(user);
        var initialResources = initResourceService.initialize(user);

        user.initialize(
                initialPlanets,
                initialMissions,
                initialResources
        );
    }

    public Level initialLevel() {

        return levelService.initialLevel();
    }
}
