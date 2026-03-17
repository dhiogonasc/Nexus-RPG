package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.model.entity.Planet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanetMapper {
    PlanetDTO toDTO(Planet planet);
}
