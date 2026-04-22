package com.nexus.nexusrpg.user.mapper;

import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.controller.dto.LevelDTO;
import com.nexus.nexusrpg.domain.mapper.LevelMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UMissionReferenceMapper;
import com.nexus.nexusrpg.domain.mapper.reference.UPlanetReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import com.nexus.nexusrpg.user.controller.dto.UserProgressionDTO;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UProgressionMapper implements Mapper<User, UserProgressionDTO> {

    private final LevelMapper levelMapper;
    private final UPlanetReferenceMapper uPlanetRefMapper;
    private final UMissionReferenceMapper uMissionRefMapper;

    @Override
    public UserProgressionDTO toDTO(User user) {
        return new UserProgressionDTO(
                mapCurrentLevel(user),
                mapCurrentPlanet(user),
                mapCurrentMission(user)
        );
    }

    private LevelDTO mapCurrentLevel(User user){
        return levelMapper.toDTO(user.getLevel());
    }

    private EntityReferenceDTO mapCurrentPlanet(User user){
        return user.getPlanets().stream()
                .filter(UPlanet::isCurrent)
                .findFirst()
                .map(uPlanetRefMapper::toReferenceDTO)
                .orElse(null);
    }

    private EntityReferenceDTO mapCurrentMission(User user){
        return user.getMissions().stream()
                .filter(UMission::isCurrent)
                .findFirst()
                .map(uMissionRefMapper::toReferenceDTO)
                .orElse(null);
    }
}
