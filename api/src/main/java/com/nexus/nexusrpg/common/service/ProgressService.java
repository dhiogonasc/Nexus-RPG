package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgressService {

    private final UserPlanetRepository userPlanetRepository;
    private final UserMissionRepository userMissionRepository;

    public void completeMission(UserMission mission){

        mission.complete();

        Long userId = mission.getUser().getId();
        Long planetId = mission.getMission().getPlanet().getId();

        int nextMissionOrder = mission.getMission().getOrder() + 1;

        userMissionRepository.findByUserIdAndPlanetIdAndMissionOrder(userId, planetId, nextMissionOrder)
                .ifPresentOrElse(
                        this::unlockMission,
                        () -> this.completePlanet(userId, mission.getMission().getPlanet())
                );
    }

    private void unlockMission(UserMission mission) {

        mission.unlock();
        userMissionRepository.save(mission);
    }

    private void completePlanet(Long userId, Planet planet) {

        userPlanetRepository.findByUserIdAndPlanetId(userId, planet.getId())
                .ifPresent(UserPlanet::complete);

        int nextPlanetOrder = planet.getOrder() + 1;
        userPlanetRepository.findByUserIdAndPlanetOrder(userId, nextPlanetOrder)
                .ifPresent(this::unlockPlanet);
    }

    private void unlockPlanet(UserPlanet planet) {

        planet.unlock();
        userPlanetRepository.save(planet);

        userMissionRepository.findByUserIdAndPlanetIdAndMissionOrder(
                planet.getUser().getId(),
                planet.getPlanet().getId(),
                1
        ).ifPresent(this::unlockMission);
    }
}
