package com.nexus.nexusrpg.domain.user.mapper;

import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionRefDTO;
import com.nexus.nexusrpg.domain.entity.mission.mapper.UserMissionMapper;
import com.nexus.nexusrpg.domain.entity.mission.model.UserMission;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.domain.entity.planet.mapper.UserPlanetMapper;
import com.nexus.nexusrpg.domain.entity.planet.model.UserPlanet;
import com.nexus.nexusrpg.domain.entity.resource.controller.dto.UserResourceRefDTO;
import com.nexus.nexusrpg.domain.entity.resource.mapper.UserResourceMapper;
import com.nexus.nexusrpg.domain.entity.resource.model.UserResource;
import com.nexus.nexusrpg.domain.user.controller.dto.UserDTO;
import com.nexus.nexusrpg.domain.entity.level.mapper.LevelMapper;
import com.nexus.nexusrpg.domain.user.model.User;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring", uses = {
        LevelMapper.class,
        UserPlanetMapper.class,
        UserMissionMapper.class,
        UserResourceMapper.class
})
public abstract class UserMapper implements CurrentEntityMapper{

    @Autowired
    protected UserPlanetMapper planetMapper;

    @Autowired
    protected UserMissionMapper missionMapper;

    @Autowired
    protected UserResourceMapper resourceMapper;

    @Mapping(target = "current.level", source = "level")
    @Mapping(target = "current.planet", source = "planets")
    @Mapping(target = "current.mission", source = "missions")
    @Mapping(target = "current.resource", source = "resources")
    public abstract UserDTO toDTO(User user);

    protected UserPlanetReferenceDTO mapCurrentPlanet(List<UserPlanet> planets) {
        return mapCurrent(planets, planetMapper::toReferenceDTO);
    }

    protected UserMissionRefDTO mapCurrentMission(List<UserMission> missions) {
        return mapCurrent(missions, missionMapper::toReferenceDTO);
    }

    protected UserResourceRefDTO mapCurrentResource(List<UserResource> resources) {
        return mapCurrent(resources, resourceMapper::toReferenceDTO);
    }
}
