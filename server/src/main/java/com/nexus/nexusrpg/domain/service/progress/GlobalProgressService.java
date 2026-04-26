package com.nexus.nexusrpg.domain.service.progress;

import com.nexus.nexusrpg.domain.model.relation.Attempt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class GlobalProgressService {

    private final MissionProgressService missionProgressService;

    public void process(Attempt attempt) {
        var result = attempt.getResult();
        var currentMission = attempt.getUMission();

        if(result.compareTo(BigDecimal.valueOf(70))>=0){
            missionProgressService.processProgress(currentMission);
        }
    }
}