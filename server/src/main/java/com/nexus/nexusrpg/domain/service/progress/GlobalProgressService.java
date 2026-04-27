package com.nexus.nexusrpg.domain.service.progress;

import com.nexus.nexusrpg.domain.model.relation.Attempt;
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
    }
}