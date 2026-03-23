package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.domain.mission.model.Mission;
import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.nexus.nexusrpg.common.enums.EntityStatus.COMPLETED;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgressService {

    private final UserPlanetRepository userPlanetRepository;
    private final UserMissionRepository userMissionRepository;

    public void completeMission(User user, Mission mission) {

        Long missionId = mission.getId();
        Long userId = user.getId();

        userMissionRepository
                .findByUserIdAndMissionId(userId, missionId)
                .ifPresent(UserMission::complete);

        Planet planet = mission.getPlanet();
        Long planetId = planet.getId();

        int currentOrder = mission.getOrder();
        int nextOrder = currentOrder + 1;

        userMissionRepository
                .findByUserIdAndPlanetIdAndMissionOrder(
                        userId,
                        planetId,
                        nextOrder
                )
                .ifPresentOrElse(
                        m -> unlockMission(user, m),
                        () -> completePlanet(user, planet)
                );

        updatePlanetProgress(user, planet);
    }

    private void completePlanet(User user, Planet planet) {

        Long userId = user.getId();
        Long planetId = planet.getId();

        userPlanetRepository
                .findByUserIdAndPlanetId(userId, planetId)
                .ifPresent(UserPlanet::complete);

        int nextOrder = planet.getOrder() + 1;

        userPlanetRepository
                .findByUserIdAndPlanetOrder(userId, nextOrder)
                .ifPresent(p -> unlockPlanet(user, p));

        user.fillOxygen();
    }

    private void unlockPlanet(User user, UserPlanet nextPlanet) {

        nextPlanet.unlock();

        Long userId = nextPlanet.getUser().getId();
        Long planetId = nextPlanet.getPlanet().getId();
        int missionOrder = 1;

        userMissionRepository
                .findByUserIdAndPlanetIdAndMissionOrder(userId, planetId, missionOrder)
                .ifPresent(m -> unlockMission(user, m));

        user.setCurrentPlanet(nextPlanet.getPlanet());
    }

    private void unlockMission(User user, UserMission nextMission) {

        nextMission.unlock();
        user.setCurrentMission(nextMission.getMission());
    }

    private void updatePlanetProgress(User user, Planet planet){

        Long userId = user.getId();
        Long planetId = planet.getId();

        UserPlanet up = userPlanetRepository
                .findByUserIdAndPlanetIdOrThrow(userId, planetId);

        int totalMissions = planet.getMissions().size();
        int completedMissions = userMissionRepository
                .countMissionsByStatus(userId, planetId, COMPLETED);

        BigDecimal progress = BigDecimal.valueOf(completedMissions)
                .divide(BigDecimal.valueOf(totalMissions), 2, RoundingMode.HALF_UP);

        up.setProgress(progress);
    }
}
