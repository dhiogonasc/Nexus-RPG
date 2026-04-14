package com.nexus.nexusrpg.domain.planet.mapper;

import com.nexus.nexusrpg.domain.planet.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.planet.model.Planet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlanetMapper {

    @Mapping(target = "missions", ignore = true)
    @Mapping(target = "resource", ignore = true)
    PlanetDTO toDTO(Planet planet);
}
