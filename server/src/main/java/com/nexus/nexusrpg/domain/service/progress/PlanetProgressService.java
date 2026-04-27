package com.nexus.nexusrpg.domain.service.progress;

import com.nexus.nexusrpg.common.service.EntityProgressService;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.domain.repository.relation.UserPlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanetProgressService extends EntityProgressService<UPlanet> {

    private final UserPlanetRepository repository;

    @Override
    protected Optional<UPlanet> findEntityByOrder(UPlanet current, int order) {
        return repository
                .findByUserIdAndPlanetOrder(
                        current.getUser().getId(),
                        order
                );
    }

    @Override
    protected void onUnlock(UPlanet currentPlanet) {
        var firstMission = currentPlanet.getFirstMission();
        firstMission.unlock();
    }
}
