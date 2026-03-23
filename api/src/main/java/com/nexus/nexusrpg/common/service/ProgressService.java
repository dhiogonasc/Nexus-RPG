package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgressService {

    private final UserPlanetRepository userPlanetRepository;
    private final UserMissionRepository userMissionRepository;

    public void completeMission(UserMission mission){

        mission.complete();

        User user = mission.getUser();
        Long userId = user.getId();

        Planet planet = mission.getMission().getPlanet();
        Long planetId = planet.getId();

        int nextMissionOrder = mission.getMission().getOrder() + 1;

        userMissionRepository.findByUserIdAndPlanetIdAndMissionOrder(userId, planetId, nextMissionOrder)
                .ifPresentOrElse(m -> {
                            unlockMission(m);
                            user.setCurrentMission(m.getMission());
                        },
                        () -> this.completePlanet(user, planet)
                );
    }

    private void unlockMission(UserMission mission) {

        mission.unlock();
        userMissionRepository.save(mission);
    }

    private void completePlanet(User user, Planet planet) {

        userPlanetRepository.findByUserIdAndPlanetId(user.getId(), planet.getId())
                .ifPresent(UserPlanet::complete);

        int nextPlanetOrder = planet.getOrder() + 1;
        userPlanetRepository.findByUserIdAndPlanetOrder(user.getId(), nextPlanetOrder)
                .ifPresent(p -> {
                    unlockPlanet(p);
                    user.setCurrentPlanet(p.getPlanet());
                });

        user.fillOxygen();
    }

    private void unlockPlanet(UserPlanet planet) {

        planet.unlock();
        userPlanetRepository.save(planet);

        Long userId = planet.getUser().getId();
        Long planetId = planet.getPlanet().getId();
        int missionOrder = 1;

        userMissionRepository
                .findByUserIdAndPlanetIdAndMissionOrder(userId, planetId, missionOrder)
                .ifPresent(this::unlockMission);
    }
}
