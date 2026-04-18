package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.UMissionRepository;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.domain.repository.UPlanetRepository;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.repository.UResourceRepository;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.*;

@Service
@RequiredArgsConstructor
public class ProgressionService {

    private final UMissionRepository uMissionRepository;
    private final UPlanetRepository uPlanetRepository;
    private final UResourceRepository uResourceRepository;

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
                        () -> unlockNextPlanet(user.getId(), currentMission.getPlanet())
                );
    }

    private void unlockMission(UMission um) {

        if (um.getExecution().getStatus() == LOCKED) {
            um.unlock();
            uMissionRepository.save(um);
        }
    }

    private void unlockNextPlanet(Long userId, Planet currentPlanet) {

        uPlanetRepository
                .findByUserIdAndPlanetOrder(
                        userId,
                        currentPlanet.getOrder()
                )
                .ifPresent(up -> {
                    this.completePlanet(up);
                    this.completeResource(userId, up.getPlanet().getResources().get(0));
                });

        uPlanetRepository
                .findByUserIdAndPlanetOrder(
                        userId,
                        currentPlanet.getOrder() + 1
                )
                .ifPresent(up -> {
                    this.unlockPlanet(up);
                    this.unlockResource(userId, up.getPlanet().getResources().get(0));
                    unlockFirstMissionOfPlanet(userId, up.getPlanet().getId());
                });
    }

    private void unlockPlanet(UPlanet up){
        if (up.getExecution().getStatus() == LOCKED) {
            up.getExecution().unlock();
            uPlanetRepository.save(up);
        }
    }

    private void completePlanet(UPlanet up){
        if (up.getExecution().getStatus() == UNLOCKED) {
            up.getExecution().complete();
            uPlanetRepository.save(up);
        }
    }

    private void completeResource(Long userId, Resource currentResource){

        uResourceRepository
                .findUEntity(
                        userId,
                        currentResource.getId()
                )
                .ifPresent(ur -> {
                    if (ur.getExecution().getStatus() == UNLOCKED) {
                        ur.getExecution().complete();
                        uResourceRepository.save(ur);
                    }
                });
    }

    private void unlockResource(Long userId, Resource currentResource){

        uResourceRepository
                .findUEntity(
                        userId,
                        currentResource.getId()
                )
                .ifPresent(ur -> {
                    if (ur.getExecution().getStatus() == LOCKED) {
                        ur.getExecution().unlock();
                        uResourceRepository.save(ur);
                    }
                });
    }

    private void unlockFirstMissionOfPlanet(Long userId, Long planetId) {

        uMissionRepository
                .findByUserIdAndMissionPlanetIdAndMissionOrder(userId, planetId, 1)
                .ifPresent(this::unlockMission);
    }
}