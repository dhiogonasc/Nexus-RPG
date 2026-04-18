package com.nexus.nexusrpg.user.mapper;

import com.nexus.nexusrpg.domain.mapper.LevelMapper;
import com.nexus.nexusrpg.domain.mapper.reference.MissionRefMapper;
import com.nexus.nexusrpg.domain.mapper.reference.PlanetRefMapper;
import com.nexus.nexusrpg.domain.model.relation.UserMission;
import com.nexus.nexusrpg.domain.model.relation.UserPlanet;
import com.nexus.nexusrpg.user.controller.dto.CurrentDTO;
import com.nexus.nexusrpg.user.controller.dto.UserDTO;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper{

    private final LevelMapper levelMapper;
    private final PlanetRefMapper planetRefMapper;
    private final MissionRefMapper missionRefMapper;

    public UserDTO toDTO(User user){

        var current = mapCurrent(user);

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getXp(),
                user.getOxygen(),
                current
        );
    }

    private CurrentDTO mapCurrent(User user){

        var currentLevel = levelMapper.toReferenceDTO(user.getLevel());

        var currentPlanet = user.getPlanets().stream()
                .filter(UserPlanet::isCurrent)
                .findFirst()
                .map(planetRefMapper::toRefDTO)
                .orElse(null);

        var currentMission = user.getMissions().stream()
                .filter(UserMission::isCurrent)
                .findFirst()
                .map(missionRefMapper::toRefDTO)
                .orElse(null);

        return new CurrentDTO(
                currentLevel,
                currentPlanet,
                currentMission
        );
    }
}
