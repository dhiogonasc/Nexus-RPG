package com.nexus.nexusrpg.user.mapper;

import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.LevelDTO;
import com.nexus.nexusrpg.domain.mapper.LevelMapper;
import com.nexus.nexusrpg.domain.mapper.current.CurrentMissionMapper;
import com.nexus.nexusrpg.domain.mapper.current.CurrentPlanetMapper;
import com.nexus.nexusrpg.user.controller.dto.UserProgressionDTO;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UProgressionMapper implements Mapper<User, UserProgressionDTO>  {

    private final LevelMapper levelMapper;
    private final CurrentPlanetMapper currentPlanetMapper;
    private final CurrentMissionMapper currentMissionMapper;

    @Override
    public UserProgressionDTO map(User user) {

        var currentPlanet = currentPlanetMapper.map(user.getPlanets());
        var currentMission = currentMissionMapper.map(user.getMissions());

        return new UserProgressionDTO(
                mapCurrentLevel(user),
                currentPlanet,
                currentMission
        );
    }

    private LevelDTO mapCurrentLevel(User user){
        return levelMapper.map(user.getLevel());
    }
}
