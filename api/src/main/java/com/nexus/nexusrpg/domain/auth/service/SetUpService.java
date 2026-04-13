package com.nexus.nexusrpg.domain.auth.service;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.level.repository.LevelRepository;
import com.nexus.nexusrpg.domain.mission.repository.MissionRepository;
import com.nexus.nexusrpg.domain.planet.repository.PlanetRepository;
import com.nexus.nexusrpg.domain.resource.repository.ResourceRepository;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.nexus.nexusrpg.common.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.common.enums.EntityStatus.UNLOCKED;

@Service
@RequiredArgsConstructor
public class SetUpService {

    private final LevelRepository levelRepository;
    private final PlanetRepository planetRepository;
    private final MissionRepository missionRepository;
    private final ResourceRepository resourceRepository;

    public void setUpInitialLevel(User user){

        var level = levelRepository.findById(1L)
                .orElseThrow(() -> new BusinessException("Level", "Level 1 não encontrado", HttpStatus.BAD_REQUEST));

        user.setLevel(level);
    }

    public void setUpInitialUserPlanets(User user){

        List<UserPlanet> userPlanets = planetRepository.findAll().stream()
                .map(p -> {
                    boolean isFirst = p.getId().equals(1L);
                    return UserPlanet.builder()
                            .user(user)
                            .planet(p)
                            .status(isFirst ? UNLOCKED : LOCKED)
                            .isAccessible(isFirst)
                            .isCurrent(isFirst)
                            .build();
                })
                .toList();

        user.getPlanets().addAll(userPlanets);
    }

    public void setUpInitialUserMissions(User user){

        List<UserMission> userMissions = missionRepository.findAll().stream()
                .map(m -> {
                    boolean isFirst = m.getId().equals(1L);
                    return UserMission.builder()
                            .user(user)
                            .mission(m)
                            .status(isFirst ? UNLOCKED : LOCKED)
                            .isAccessible(isFirst)
                            .isCurrent(isFirst)
                            .build();
                })
                .toList();

        user.getMissions().addAll(userMissions);
    }

    public void setUpInitialUserResources(User user){

        List<UserResource> userResources = resourceRepository.findAll().stream()
                .map(r -> UserResource.builder()
                        .user(user)
                        .resource(r)
                        .collected(false)
                        .build()
                )
                .toList();

        user.getResources().addAll(userResources);
    }

    public void initialStats(User user) {

        user.fillOxygen();
        user.setXp(0);
    }
}
