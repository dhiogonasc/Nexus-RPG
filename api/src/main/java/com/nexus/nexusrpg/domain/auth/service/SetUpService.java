package com.nexus.nexusrpg.domain.auth.service;

import com.nexus.nexusrpg.common.enums.EntityStatus;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.level.model.Level;
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

@Service
@RequiredArgsConstructor
public class SetUpService {

    private final LevelRepository levelRepository;
    private final PlanetRepository planetRepository;
    private final MissionRepository missionRepository;
    private final ResourceRepository resourceRepository;

    public void setUpInitialLevel(User user){

        Level level = levelRepository.findById(1L)
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
                            .status(isFirst ? EntityStatus.UNLOCKED : EntityStatus.LOCKED)
                            .isAccessible(isFirst)
                            .build();
                })
                .toList();

        UserPlanet firstUP = userPlanets.stream()
                .filter(up -> up.getPlanet().getId().equals(1L))
                .findFirst()
                .orElseThrow(() -> new BusinessException("Planet", "Planeta 1 não encontrado", HttpStatus.NOT_FOUND));

        user.setCurrentPlanet(firstUP.getPlanet());
        user.getPlanets().addAll(userPlanets);
    }

    public void setUpInitialUserMissions(User user){

        List<UserMission> userMissions = missionRepository.findAll().stream()
                .map(m -> {
                    boolean isFirst = m.getId().equals(1L);
                    return UserMission.builder()
                            .user(user)
                            .mission(m)
                            .status(isFirst ? EntityStatus.UNLOCKED : EntityStatus.LOCKED)
                            .isAccessible(isFirst)
                            .build();
                })
                .toList();

        UserMission firstUM = userMissions.stream()
                .filter(um -> um.getMission().getId().equals(1L))
                .findFirst()
                .orElseThrow(() -> new BusinessException("Mission", "Missão 1 não encontrada", HttpStatus.NOT_FOUND));

        user.setCurrentMission(firstUM.getMission());
        user.getMissions().addAll(userMissions);
    }

    public void setUpInitialUserResources(User user){

        List<UserResource> userResources = resourceRepository.findAll().stream()
                .map(r -> UserResource.builder()
                        .user(user)
                        .resource(r)
                        .isCollected(false)
                        .build()
                )
                .toList();

        user.getResources().addAll(userResources);
    }
}
