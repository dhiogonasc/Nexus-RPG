package com.nexus.nexusrpg.domain.service.progress;

import com.nexus.nexusrpg.domain.model.enums.EntityStatus;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class GlobalProgressService {

    private final BigDecimal PROGRESS_THRESHOLD = BigDecimal.valueOf(70);

    private final LevelService levelService;
    private final MissionProgressService missionProgressService;
    private final PlanetProgressService planetProgressService;

    @Transactional
    public void process(Attempt attempt) {
        if (attempt.getResult().compareTo(PROGRESS_THRESHOLD) < 0){
            return;
        }

        var currentMission = attempt.getUMission();
        missionProgressService.process(currentMission);

        check(currentMission);

        levelService.levelUp(currentMission.getUser());
    }

    private void check(UMission currentMission){
        if (currentMission.isLast() && currentMission.getStatus() == EntityStatus.COMPLETED){
            var currentPlanet = currentMission.getUPlanet();
            planetProgressService.process(currentPlanet);
        }
    }
}