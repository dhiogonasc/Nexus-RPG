package com.nexus.nexusrpg.user.mapper;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.level.LevelDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionDTOR;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;
import com.nexus.nexusrpg.domain.mapper.LevelMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UMissionRefMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetRefMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.user.controller.dto.ProgressionDTO;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProgressionMapper implements Mapper<User, ProgressionDTO> {

    private final LevelMapper levelMapper;
    private final UPlanetRefMapper uPlanetRefMapper;
    private final UMissionRefMapper uMissionRefMapper;

    @Override
    public ProgressionDTO toDTO(User user) {
        return new ProgressionDTO(
                mapCurrentLevel(user),
                mapCurrentPlanet(user),
                mapCurrentMission(user)
        );
    }

    private LevelDTO mapCurrentLevel(User user){
        return levelMapper.toDTO(user.getLevel());
    }

    private UPlanetDTOR mapCurrentPlanet(User user){
        return user.getPlanets().stream()
                .filter(UPlanet::isCurrent)
                .findFirst()
                .map(uPlanetRefMapper::toRefDTO)
                .orElse(null);
    }

    private UMissionDTOR mapCurrentMission(User user){
        return user.getMissions().stream()
                .filter(UMission::isCurrent)
                .findFirst()
                .map(uMissionRefMapper::toRefDTO)
                .orElse(null);
    }
}
