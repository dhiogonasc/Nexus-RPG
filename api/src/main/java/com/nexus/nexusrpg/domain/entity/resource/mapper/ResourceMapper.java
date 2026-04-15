package com.nexus.nexusrpg.domain.entity.resource.mapper;

import com.nexus.nexusrpg.domain.entity.resource.controller.dto.ResourceDTO;
import com.nexus.nexusrpg.domain.entity.resource.controller.dto.ResourceReferenceDTO;
import com.nexus.nexusrpg.domain.entity.resource.model.Resource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResourceMapper {

    ResourceDTO toDTO(Resource resource);
    ResourceReferenceDTO toReferenceDTO(Resource resource);
}
