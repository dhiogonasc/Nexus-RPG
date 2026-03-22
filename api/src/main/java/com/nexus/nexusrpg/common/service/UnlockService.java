package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.common.enums.EntityStatus;
import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnlockService {

    private final UserPlanetRepository userPlanetRepository;
    private final UserMissionRepository userMissionRepository;

    public void completeMission(UserMission userMission){

        userMission.setStatus(EntityStatus.COMPLETED);

        Long userId = userMission.getUser().getId();
        int nextMissionOrder = userMission.getMission().getOrder() + 1;
        Long planetId = userMission.getMission().getPlanet().getId();

        userMissionRepository.findByUserIdAndPlanetIdAndMissionOrder(userId, planetId, nextMissionOrder)
                .ifPresentOrElse(
                        this::unlockMission,
                        () -> this.completePlanet(userId, userMission.getMission().getPlanet())
                );
    }

    private void unlockMission(UserMission mission) {

        mission.setStatus(EntityStatus.UNLOCKED);
        mission.setIsAccessible(true);

        userMissionRepository.save(mission);
    }

    private void completePlanet(Long userId, Planet planet) {

        userPlanetRepository.findByUserIdAndPlanetId(userId, planet.getId())
                .ifPresent(up -> up.setStatus(EntityStatus.COMPLETED));

        int nextPlanetOrder = planet.getOrder() + 1;
        userPlanetRepository.findByUserIdAndPlanetOrder(userId, nextPlanetOrder)
                .ifPresent(this::unlockPlanet);
    }

    private void unlockPlanet(UserPlanet planet) {

        planet.setStatus(EntityStatus.UNLOCKED);
        planet.setIsAccessible(true);
        userPlanetRepository.save(planet);

        userMissionRepository.findByUserIdAndPlanetIdAndMissionOrder(
                planet.getUser().getId(),
                planet.getPlanet().getId(),
                1
        ).ifPresent(this::unlockMission);
    }
}
