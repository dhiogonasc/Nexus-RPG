package com.nexus.nexusrpg.domain.entity.planet.mapper;

import com.nexus.nexusrpg.domain.entity.mission.mapper.UserMissionMapper;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetDTO;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.domain.entity.planet.model.UserPlanet;
import com.nexus.nexusrpg.domain.entity.resource.mapper.UserResourceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        UserMissionMapper.class,
        UserResourceMapper.class
})
public interface UserPlanetMapper {

    @Mapping(target = ".", source = "planet")
    UserPlanetDTO toDTO(UserPlanet userPlanet);

    @Mapping(target = ".", source = "planet")
    UserPlanetReferenceDTO toReferenceDTO(UserPlanet userPlanet);
}
