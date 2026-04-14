package com.nexus.nexusrpg.domain.user.mapper;

import com.nexus.nexusrpg.domain.resource.mapper.ResourceMapper;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionAttemptDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceReferenceDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.UserDTO;
import com.nexus.nexusrpg.domain.level.mapper.LevelMapper;
import com.nexus.nexusrpg.domain.mission.mapper.MissionMapper;
import com.nexus.nexusrpg.domain.planet.mapper.PlanetMapper;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserMissionAttempt;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import org.mapstruct.*;

import java.util.List;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring", uses = {
        PlanetMapper.class,
        MissionMapper.class,
        ResourceMapper.class,
        LevelMapper.class
})
public interface UserMapper {

    UserDTO toDTO(User user);

    UserPlanetDTO toUserPlanetDTO(UserPlanet userPlanet);

    UserMissionDTO toUserMissionDTO(UserMission userMission);

    UserResourceDTO toUserResourceDTO(UserResource userResource);

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

    @Mapping(source = "mission", target = "mission")
    UserMissionReferenceDTO toUserMissionReferenceDTO(UserMission userMission);

    UserResourceReferenceDTO toUserResourceReferenceDTO(UserResource userResource);

    UserMissionAttemptDTO toUserMissionAttemptDTO(UserMissionAttempt attempt);
}
