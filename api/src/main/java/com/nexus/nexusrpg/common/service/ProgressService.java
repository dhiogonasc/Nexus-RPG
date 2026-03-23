package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.user.model.entity.User;
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

        User user = mission.getUser();
        Planet planet = mission.getMission().getPlanet();

        int nextMissionOrder = mission.getMission().getOrder() + 1;

        userMissionRepository.findByUserIdAndPlanetIdAndMissionOrder(user.getId(), planet.getId(), nextMissionOrder)
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

        userMissionRepository.findByUserIdAndPlanetIdAndMissionOrder(
                planet.getUser().getId(),
                planet.getPlanet().getId(),
                1
        ).ifPresent(this::unlockMission);
    }
}
