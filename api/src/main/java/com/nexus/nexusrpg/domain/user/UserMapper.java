package com.nexus.nexusrpg.domain.user;

import com.nexus.nexusrpg.controller.dto.user.mission.UserMissionDTO;
import com.nexus.nexusrpg.controller.dto.user.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.controller.dto.user.planet.UserPlanetDTO;
import com.nexus.nexusrpg.controller.dto.user.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.controller.dto.global.resource.CollectedResourcesDTO;
import com.nexus.nexusrpg.controller.dto.user.resource.UserResourceDTO;
import com.nexus.nexusrpg.controller.dto.user.resource.UserResourceReferenceDTO;
import com.nexus.nexusrpg.controller.dto.user.UserDTO;
import com.nexus.nexusrpg.mapper.LevelMapper;
import com.nexus.nexusrpg.mapper.MissionMapper;
import com.nexus.nexusrpg.mapper.PlanetMapper;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import org.mapstruct.*;

import java.math.BigDecimal;
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
                .filter(UserResource::isCollected)
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
