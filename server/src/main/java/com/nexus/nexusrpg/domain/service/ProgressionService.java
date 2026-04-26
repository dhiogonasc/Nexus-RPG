package com.nexus.nexusrpg.domain.service;

import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.UNLOCKED;

@Service
@RequiredArgsConstructor
public class ProgressionService {

    private final UserMissionRepository uMissionRepository;
    private final UserPlanetRepository uPlanetRepository;

    @Transactional
    public void unlockNextMission(User user, Mission currentMission) {
        uMissionRepository
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

    private void unlockNextPlanet(User user, Planet currentPlanet) {
        uPlanetRepository
                .findByUserIdAndPlanetOrder(
                        user.getId(),
                        currentPlanet.getOrder()
                )
                .ifPresent(uPlanet -> {
                    this.completePlanet(uPlanet);
                    user.addXp(uPlanet.getXpBonus());
                });

        uPlanetRepository
                .findByUserIdAndPlanetOrder(
                        user.getId(),
                        currentPlanet.getOrder() + 1
                )
                .ifPresent(up -> {
                    this.unlockPlanet(up);
                    unlockFirstMissionOfPlanet(user.getId(), up.getPlanet().getId());
                });
    }

    private void unlockMission(UMission um) {
        if (um.getExecution().getStatus() == LOCKED) {
            um.unlock();
            uMissionRepository.save(um);
        }
    }

    private void unlockPlanet(UPlanet up){
        if (up.getStatus() == LOCKED) {
            up.unlock();
            uPlanetRepository.save(up);
        }
    }

    private void completePlanet(UPlanet up){
        if (up.getStatus() == UNLOCKED) {
            up.complete();
            uPlanetRepository.save(up);
        }
    }

    private void unlockFirstMissionOfPlanet(Long userId, Long planetId) {
        uMissionRepository
                .findByUserIdAndMissionPlanetIdAndMissionOrder(userId, planetId, 1)
                .ifPresent(this::unlockMission);
    }
}