package com.nexus.nexusrpg.domain.entity.planet.mapper;

import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetDTO;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        PlanetMapper.class
})
public interface UserPlanetMapper {

    UserPlanetDTO toDTO(UserPlanet userPlanet);
    UserPlanetReferenceDTO toReferenceDTO(UserPlanet userPlanet);
}
