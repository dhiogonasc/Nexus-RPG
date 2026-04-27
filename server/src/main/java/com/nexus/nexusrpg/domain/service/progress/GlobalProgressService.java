package com.nexus.nexusrpg.domain.service.progress;

import com.nexus.nexusrpg.domain.model.enums.EntityStatus;
import com.nexus.nexusrpg.domain.model.relation.Attempt;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class GlobalProgressService {

    private final BigDecimal PROGRESS_THRESHOLD = BigDecimal.valueOf(70);

    private final MissionProgressService missionProgressService;
    private final PlanetProgressService planetProgressService;

    public void process(Attempt attempt) {
        if (attempt.getResult().compareTo(PROGRESS_THRESHOLD) < 0){
            return;
        }

        var currentMission = attempt.getUMission();
        missionProgressService.process(currentMission);

        check(currentMission);
    }

    private void check(UMission currentMission){
        if (currentMission.isLast() && currentMission.getStatus() == EntityStatus.COMPLETED){
            planetProgressService.process(currentMission.getUPlanet());

        }
    };
}