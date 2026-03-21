package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.*;
import com.nexus.nexusrpg.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.controller.dto.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.controller.dto.resource.UserResourceDTO;
import com.nexus.nexusrpg.controller.dto.resource.UserResourceReferenceDTO;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.model.relation.UserMission;
import com.nexus.nexusrpg.model.relation.UserPlanet;
import com.nexus.nexusrpg.model.relation.UserResource;
import org.mapstruct.*;

import java.util.List;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring", uses = {
        PlanetMapper.class,
        MissionMapper.class,
        LevelMapper.class
})
public interface UserMapper {

    @Mapping(target = "currentPlanet", expression = "java(mapCurrentPlanet(user))")
    @Mapping(target = "currentMission", expression = "java(mapCurrentMission(user))")
    @Mapping(target = "collectedResources", expression = "java(mapCollectedResources(user.getResources()))")
    UserDTO toDTO(User user);


    UserPlanetDTO toUserPlanetDTO(UserPlanet userPlanet);

    UserMissionDTO toUserMissionDTO(UserMission userMission);

    UserResourceDTO toUserResourceDTO(UserResource userResource);

    default UserPlanetReferenceDTO mapCurrentPlanet(User user) {
        if (user.getCurrentPlanet() == null || user.getPlanets() == null) return null;

        return user.getPlanets().stream()
                .filter(up -> up.getPlanet().getId().equals(user.getCurrentPlanet().getId()))
                .findFirst()
                .map(this::toUserPlanetReferenceDTO)
                .orElse(null);
    }

    default UserMissionReferenceDTO mapCurrentMission(User user) {
        if (user.getCurrentMission() == null || user.getMissions() == null) return null;

        return user.getMissions().stream()
                .filter(um -> um.getMission().getId().equals(user.getCurrentMission().getId()))
                .findFirst()
                .map(this::toUserMissionReferenceDTO)
                .orElse(null);
    }

    default List<UserMissionReferenceDTO> mapMissions(UserPlanet userPlanet) {

        if (userPlanet == null || userPlanet.getUser() == null || userPlanet.getUser().getMissions() == null) {
            return List.of();
        }

        Long planetId = userPlanet.getPlanet().getId();

        return userPlanet.getUser().getMissions().stream()
                .filter(um -> um.getMission().getPlanet().getId().equals(planetId))
                .map(this::toUserMissionReferenceDTO)
                .toList();
    }

    default List<UserResourceReferenceDTO> mapCollectedResources(List<UserResource> resources) {
        if (resources == null) return List.of();

        return resources.stream()
                .filter(UserResource::isCollected) // O segredo está aqui
                .map(this::toUserResourceReferenceDTO)
                .toList();
    }

    UserPlanetReferenceDTO toUserPlanetReferenceDTO(UserPlanet userPlanet);
    UserMissionReferenceDTO toUserMissionReferenceDTO(UserMission userMission);
    UserResourceReferenceDTO toUserResourceReferenceDTO(UserResource userResource);
}
