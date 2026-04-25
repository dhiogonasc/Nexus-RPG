package com.nexus.nexusrpg.user.mapper;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.mapper.current.CurrentLevelMapper;
import com.nexus.nexusrpg.domain.mapper.current.CurrentMissionMapper;
import com.nexus.nexusrpg.domain.mapper.current.CurrentPlanetMapper;
import com.nexus.nexusrpg.user.controller.dto.UserProgressionDTO;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UProgressionMapper implements Mapper<User, UserProgressionDTO>  {

    private final CurrentLevelMapper currentLevelMapper;
    private final CurrentPlanetMapper currentPlanetMapper;
    private final CurrentMissionMapper currentMissionMapper;

    @Override
    public UserProgressionDTO map(User user) {

        var currentPlanet = currentPlanetMapper.map(user.getPlanets());
        var currentMission = currentMissionMapper.map(user.getMissions());

        return new UserProgressionDTO(
                currentLevelMapper.map(user.getLevel()),
                currentPlanet,
                currentMission
        );
    }
}
