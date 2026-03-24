package com.nexus.nexusrpg.domain.planet.mapper;

import com.nexus.nexusrpg.domain.mission.mapper.MissionMapper;
import com.nexus.nexusrpg.domain.planet.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.planet.controller.dto.PlanetReferenceDTO;
import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.resource.mapper.ResourceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        MissionMapper.class,
        ResourceMapper.class
})
public interface PlanetMapper {

    @Mapping(target = "missions", ignore = true)
    @Mapping(target = "resource", ignore = true)
    PlanetDTO toDTO(Planet planet);

    PlanetReferenceDTO toReferenceDTO(Planet planet);
}
