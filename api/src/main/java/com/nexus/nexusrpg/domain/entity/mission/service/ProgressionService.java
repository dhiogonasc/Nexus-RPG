package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.domain.entity.mission.model.Mission;
import com.nexus.nexusrpg.domain.entity.mission.model.UserMission;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserMissionRepository;
import com.nexus.nexusrpg.domain.entity.planet.model.Planet;
import com.nexus.nexusrpg.domain.entity.planet.model.UserPlanet;
import com.nexus.nexusrpg.domain.entity.planet.repository.UserPlanetRepository;
import com.nexus.nexusrpg.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.UNLOCKED;

@Service
@RequiredArgsConstructor
public class ProgressionService {

    private final UserMissionRepository userMissionRepository;
    private final UserPlanetRepository userPlanetRepository;

    @Transactional
    public void unlockNextMission(User user, Mission currentMission) {

        userMissionRepository
                .findByUserIdAndMissionPlanetIdAndMissionOrder(
                        user.getId(),
                        currentMission.getPlanet().getId(),
                        currentMission.getOrder() + 1
                )
                .ifPresentOrElse(
                        this::unlockMission,
                        () -> unlockNextPlanet(user, currentMission.getPlanet())
                );
    }

    private void unlockMission(UserMission um) {

        if (um.getStats().getStatus() == LOCKED) {
            um.getStats().unlock();
            userMissionRepository.save(um);
        }
    }

    private void unlockNextPlanet(User user, Planet currentPlanet) {

        completePlanet(user.getId(), currentPlanet.getId());

        userPlanetRepository
                .findByUserIdAndPlanetOrder(
                        user.getId(),
                        currentPlanet.getOrder() + 1
                )
                .ifPresent(up -> {
                    if (up.getStats().getStatus() == LOCKED) {
                        this.unlockPlanet(up);
                        unlockFirstMissionOfPlanet(user.getId(), up.getPlanet().getId());
                    }
                });
    }

    private void completePlanet(Long userId, Long planetId) {

        userPlanetRepository.findByUserIdAndBaseId(userId, planetId)
                .ifPresent(up -> {
                    if (up.getStats().getStatus() == UNLOCKED) {
                        up.getStats().complete();
                    }
                });
    }

    private void unlockPlanet(UserPlanet up) {

        if (up.getStats().getStatus() == LOCKED) {
            up.getStats().unlock();
            userPlanetRepository.save(up);
        }
    }

    private void unlockFirstMissionOfPlanet(Long userId, Long planetId) {

        userMissionRepository
                .findByUserIdAndMissionPlanetIdAndMissionOrder(userId, planetId, 1)
                .ifPresent(this::unlockMission);
    }
}