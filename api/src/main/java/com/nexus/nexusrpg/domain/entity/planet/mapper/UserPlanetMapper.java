package com.nexus.nexusrpg.domain.entity.planet.mapper;

import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetDTO;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetStatsDTO;
import com.nexus.nexusrpg.domain.entity.planet.model.UserPlanet;
import com.nexus.nexusrpg.domain.entity.planet.model.UserPlanetStats;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {
        PlanetMapper.class
})
public interface UserPlanetMapper {

    UserPlanetDTO toDTO(UserPlanet userPlanet);
    UserPlanetReferenceDTO toReferenceDTO(UserPlanet userPlanet);
    UserPlanetStatsDTO toStatsDTO(UserPlanetStats stats);
}
