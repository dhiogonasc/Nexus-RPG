package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.*;
import com.nexus.nexusrpg.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.controller.dto.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.model.relation.UserMission;
import com.nexus.nexusrpg.model.relation.UserPlanet;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {
        PlanetMapper.class,
        MissionMapper.class,
        LevelMapper.class
})
public interface UserMapper {

    @Mapping(target = "currentPlanet", expression = "java(mapCurrentPlanet(user))")
    @Mapping(target = "currentMission", expression = "java(mapCurrentMission(user))")
    UserDTO toDTO(User user);

    UserPlanetDTO toUserPlanetDTO(UserPlanet userPlanet);
    UserMissionDTO toUserMissionDTO(UserMission userMission);

    default UserPlanetReferenceDTO mapCurrentPlanet(User user) {

        if (user.getCurrentPlanet() == null) return null;

        return user.getPlanets().stream()
                .filter(up -> up.getPlanet().getId().equals(user.getCurrentPlanet().getId()))
                .findFirst()
                .map(this::toUserPlanetReferenceDTO) // Chama o mapeamento que já existe
                .orElse(null);
    }

    default UserMissionReferenceDTO mapCurrentMission(User user) {

        if (user.getCurrentMission() == null) return null;

        return user.getMissions().stream()
                .filter(up -> up.getMission().getId().equals(user.getCurrentMission().getId()))
                .findFirst()
                .map(this::toUserMissionReferenceDTO)
                .orElse(null);
    }

    UserPlanetReferenceDTO toUserPlanetReferenceDTO(UserPlanet userPlanet);
    UserMissionReferenceDTO toUserMissionReferenceDTO(UserMission userMission);
}
