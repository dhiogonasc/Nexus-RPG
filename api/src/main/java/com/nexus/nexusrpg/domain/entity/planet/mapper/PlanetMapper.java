package com.nexus.nexusrpg.domain.entity.planet.mapper;

import com.nexus.nexusrpg.domain.entity.mission.mapper.MissionMapper;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.PlanetDTO;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.PlanetReferenceDTO;
import com.nexus.nexusrpg.domain.entity.planet.model.Planet;
import com.nexus.nexusrpg.domain.entity.resource.mapper.ResourceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        ResourceMapper.class,
        MissionMapper.class
})
public interface PlanetMapper {

    @Mapping(target = "resources", source = "resources")
    @Mapping(target = "missions", source = "missions")
    PlanetDTO toDTO(Planet planet);
    PlanetReferenceDTO toReferenceDTO(Planet planet);
}
