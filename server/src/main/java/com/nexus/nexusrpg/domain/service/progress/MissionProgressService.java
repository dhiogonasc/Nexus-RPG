package com.nexus.nexusrpg.domain.service.progress;

import com.nexus.nexusrpg.common.service.EntityProgressService;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionProgressService extends EntityProgressService<UMission> {

    private final UserMissionRepository repository;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    protected java.util.Optional<UMission> findEntityByOrder(UMission current, int order){
        var user =  current.getUser();
        var planet  = current.getPlanet();

        return repository.findByUserIdAndMissionOrderAndPlanetId(user.getId(), order, planet.getId());
    }

    @Override
    @Transactional
    public void processProgress(UMission currentMission) {
        super.processProgress(currentMission);

        if (currentMission.isLastMission()) {
            eventPublisher.publishEvent(currentMission);
        }
    }
}
