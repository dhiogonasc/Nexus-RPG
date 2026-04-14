package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.domain.level.model.Level;
import com.nexus.nexusrpg.domain.level.repository.LevelRepository;
import com.nexus.nexusrpg.domain.mission.model.Mission;
import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.resource.model.Resource;
import com.nexus.nexusrpg.domain.resource.validator.ResourceValidator;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import com.nexus.nexusrpg.domain.user.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserPlanetRepository;
import com.nexus.nexusrpg.domain.user.repository.relation.UserResourceRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.nexus.nexusrpg.common.enums.EntityStatus.COMPLETED;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgressService {

    private List<Level> levels;

    private final LevelRepository levelRepository;
    private final UserPlanetRepository userPlanetRepository;
    private final UserMissionRepository userMissionRepository;
    private final UserResourceRepository userResourceRepository;

    private final ResourceValidator resourceValidator;

    @PostConstruct
    public void init() {
        this.levels = levelRepository.findAllByOrderByXpRequiredAsc();
    }

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
                        this::unlockMission,
                        () -> completePlanet(user, planet)
                );

        updatePlanetProgress(user, planet);
        updateUserLevel(user);
    }

    private void unlockMission(UserMission nextMission) {

        nextMission.unlock();
        nextMission.setIsCurrent(true);
    }

    private void completePlanet(User user, Planet planet) {

        Long userId = user.getId();
        Long planetId = planet.getId();

        userPlanetRepository
                .findByUserIdAndPlanetId(userId, planetId)
                .ifPresent(p -> {
                    p.complete();

                    Resource resource = p.getPlanet().getResource();
                    collectResource(user, resource);
                });

        int nextOrder = planet.getOrder() + 1;

        userPlanetRepository
                .findByUserIdAndPlanetOrder(userId, nextOrder)
                .ifPresent(this::unlockPlanet);

        user.fillOxygen();
    }

    private void unlockPlanet(UserPlanet nextPlanet) {

        nextPlanet.unlock();

        Long userId = nextPlanet.getUser().getId();
        Long planetId = nextPlanet.getPlanet().getId();
        int missionOrder = 1;

        userMissionRepository
                .findByUserIdAndPlanetIdAndMissionOrder(userId, planetId, missionOrder)
                .ifPresent(this::unlockMission);

        nextPlanet.setIsCurrent(true);
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
                .divide(BigDecimal.valueOf(totalMissions), 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));

        up.setProgress(progress);
    }

    private void collectResource(User user, Resource resource){

        Long userId = user.getId();
        Long resourceId = resource.getId();

        UserResource ur = userResourceRepository.findByUserIdAndResourceIdOrThrow(userId, resourceId);

        if(ur.isCollected()){
            return;
        }

        resourceValidator.isCollectable(ur);
        ur.collect();
    }

    private void updateUserLevel(User user) {

        long userXp = user.getXp();

        Level currentLevel = levels.stream()
                .filter(lvl -> userXp >= lvl.getXpRequired())
                .reduce((first, last) -> last)
                .orElse(levels.get(0));

        user.setLevel(currentLevel);
    }
}
