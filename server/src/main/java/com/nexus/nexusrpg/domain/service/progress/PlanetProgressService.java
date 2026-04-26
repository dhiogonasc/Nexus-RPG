package com.nexus.nexusrpg.domain.service.progress;

import com.nexus.nexusrpg.common.service.EntityProgressService;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.domain.repository.relation.UserPlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.LOCKED;

@Service
@RequiredArgsConstructor
public class PlanetProgressService extends EntityProgressService<UPlanet> {

    private final UserPlanetRepository repository;

    @Override
    protected java.util.Optional<UPlanet> findEntityByOrder(UPlanet current, int order) {
        return repository.findByUserIdAndPlanetOrder(current.getUser().getId(), order);
    }

    @EventListener
    public void handleMissionCompleted(UMission uMission) {
        this.processProgress(uMission.getUPlanet());
    }

    @Override
    protected void onAfterUnlock(UPlanet nextPlanet) {
        nextPlanet.getFirstMission().ifPresent(uMission -> {
            if (uMission.getStatus() == LOCKED) uMission.unlock();
        });
    }
}
