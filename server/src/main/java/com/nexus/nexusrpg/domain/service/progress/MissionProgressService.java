package com.nexus.nexusrpg.domain.service.progress;

import com.nexus.nexusrpg.common.service.EntityProgressService;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionProgressService extends EntityProgressService<UMission> {

    private final UserMissionRepository repository;

    @Override
    protected Optional<UMission> findEntityByOrder(UMission current, int order){
        return repository
                .findByUserIdAndPlanetIdAndMissionOrder(
                        current.getUser().getId(),
                        current.getPlanet().getId(),
                        order
                );
    }
}
