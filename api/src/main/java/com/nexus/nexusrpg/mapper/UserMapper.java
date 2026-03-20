package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.*;
import com.nexus.nexusrpg.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.model.relation.UserMission;
import com.nexus.nexusrpg.model.relation.UserPlanet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        PlanetMapper.class,
        MissionMapper.class,
        LevelMapper.class
})
public interface UserMapper {
    UserDTO toDTO(User user);

    UserPlanetDTO toUserPlanetDTO(UserPlanet userPlanet);

    UserMissionDTO toUserMissionDTO(UserMission userMission);
}
