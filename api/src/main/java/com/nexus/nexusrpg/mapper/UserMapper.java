package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.*;
import com.nexus.nexusrpg.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.controller.dto.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.controller.dto.resource.CollectedResourcesDTO;
import com.nexus.nexusrpg.controller.dto.resource.UserResourceDTO;
import com.nexus.nexusrpg.controller.dto.resource.UserResourceReferenceDTO;
import com.nexus.nexusrpg.model.entity.User;
import com.nexus.nexusrpg.model.relation.UserMission;
import com.nexus.nexusrpg.model.relation.UserPlanet;
import com.nexus.nexusrpg.model.relation.UserResource;
import org.mapstruct.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static java.math.RoundingMode.HALF_UP;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring", uses = {
        PlanetMapper.class,
        MissionMapper.class,
        LevelMapper.class
})
public interface UserMapper {

    @Mapping(target = "currentPlanet", expression = "java(mapCurrentPlanet(user))")
    @Mapping(target = "currentMission", expression = "java(mapCurrentMission(user))")
    @Mapping(target = "collectedResources", expression = "java(mapCollectedResources(user))")
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

    default CollectedResourcesDTO mapCollectedResources(User user) {

        if (user.getResources() == null) {
            return new CollectedResourcesDTO(List.of(), BigDecimal.ZERO);
        }

        List<UserResourceReferenceDTO> collectedList = user.getResources().stream()
                .filter(com.nexus.nexusrpg.model.relation.UserResource::isCollected)
                .map(this::toUserResourceReferenceDTO)
                .toList();

        BigDecimal progress = BigDecimal.ZERO.setScale(2, HALF_UP);;

        return new CollectedResourcesDTO(collectedList, progress);
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

    UserPlanetReferenceDTO toUserPlanetReferenceDTO(UserPlanet userPlanet);
    UserMissionReferenceDTO toUserMissionReferenceDTO(UserMission userMission);
    UserResourceReferenceDTO toUserResourceReferenceDTO(UserResource userResource);
}
