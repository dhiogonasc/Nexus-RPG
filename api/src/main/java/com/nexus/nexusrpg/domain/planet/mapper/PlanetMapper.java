package com.nexus.nexusrpg.domain.planet.mapper;

import com.nexus.nexusrpg.domain.planet.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.planet.model.Planet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanetMapper {
    PlanetDTO toDTO(Planet planet);
}
