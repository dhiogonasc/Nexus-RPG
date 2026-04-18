package com.nexus.nexusrpg.domain.entity.mission.service;

import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.UserMission;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserMissionRepository;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.UserPlanet;
import com.nexus.nexusrpg.domain.entity.planet.repository.UserPlanetRepository;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.entity.resource.repository.UserResourceRepository;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.*;

@Service
@RequiredArgsConstructor
public class ProgressionService {

    private final UserMissionRepository userMissionRepository;
    private final UserPlanetRepository userPlanetRepository;
    private final UserResourceRepository userResourceRepository;

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
                        () -> unlockNextPlanet(user.getId(), currentMission.getPlanet())
                );
    }

    private void unlockMission(UserMission um) {

        if (um.getExecution().getStatus() == LOCKED) {
            um.getExecution().unlock();
            userMissionRepository.save(um);
        }
    }

    private void unlockNextPlanet(Long userId, Planet currentPlanet) {

        userPlanetRepository
                .findByUserIdAndPlanetOrder(
                        userId,
                        currentPlanet.getOrder()
                )
                .ifPresent(up -> {
                    this.completePlanet(up);
                    this.completeResource(userId, up.getPlanet().getResources().get(0));
                });

        userPlanetRepository
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

    private void unlockPlanet(UserPlanet up){
        if (up.getExecution().getStatus() == LOCKED) {
            up.getExecution().unlock();
            userPlanetRepository.save(up);
        }
    }

    private void completePlanet(UserPlanet up){
        if (up.getExecution().getStatus() == UNLOCKED) {
            up.getExecution().complete();
            userPlanetRepository.save(up);
        }
    }

    private void completeResource(Long userId, Resource currentResource){

        userResourceRepository
                .findByUserIdAndBaseId(
                        userId,
                        currentResource.getId()
                )
                .ifPresent(ur -> {
                    if (ur.getExecution().getStatus() == UNLOCKED) {
                        ur.getExecution().complete();
                        userResourceRepository.save(ur);
                    }
                });
    }

    private void unlockResource(Long userId, Resource currentResource){

        userResourceRepository
                .findByUserIdAndBaseId(
                        userId,
                        currentResource.getId()
                )
                .ifPresent(ur -> {
                    if (ur.getExecution().getStatus() == LOCKED) {
                        ur.getExecution().unlock();
                        userResourceRepository.save(ur);
                    }
                });
    }

    private void unlockFirstMissionOfPlanet(Long userId, Long planetId) {

        userMissionRepository
                .findByUserIdAndMissionPlanetIdAndMissionOrder(userId, planetId, 1)
                .ifPresent(this::unlockMission);
    }
}