package com.nexus.nexusrpg.domain.entity.planet.service;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.state.Progression;
import com.nexus.nexusrpg.domain.repository.relation.UPlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountPlanet implements Progression {

    private final Context context;
    private final UPlanetRepository uPlanetRepository;

    @Override
    public long getCompleted() {
        var user = context.getAuthenticatedUser();
        return uPlanetRepository.countCompletedTasks(user.getId());
    }

    @Override
    public long getTotal() {
        var user = context.getAuthenticatedUser();
        return uPlanetRepository.countTotalTasks(user.getId());
    }
}
