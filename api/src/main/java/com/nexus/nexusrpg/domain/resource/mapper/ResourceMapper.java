package com.nexus.nexusrpg.domain.resource.mapper;

import com.nexus.nexusrpg.domain.resource.controller.dto.ResourceDTO;
import com.nexus.nexusrpg.domain.resource.model.Resource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResourceMapper {

    ResourceDTO toDTO(Resource resource);
}
