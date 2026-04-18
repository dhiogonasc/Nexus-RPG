package com.nexus.nexusrpg.domain.entity.planet.service;

import com.nexus.nexusrpg.common.entity.dto.ProgressDTO;
import com.nexus.nexusrpg.common.entity.enums.EntityStatus;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserMissionRepository;
import com.nexus.nexusrpg.domain.model.relation.UserPlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanetProgress {

    private final UserMissionRepository userMissionRepository;

    public ProgressDTO calculate(UserPlanet up){

        var user = up.getUser();
        var missions =  userMissionRepository.findByUserIdAndMissionPlanetIdOrThrow(user.getId(), up.getPlanet().getId());

        var total = missions.size();
        var completed = missions.stream()
                .filter(um -> um.getStatus() == EntityStatus.COMPLETED)
                .count();

        return new ProgressDTO(completed, total);

    }
}
