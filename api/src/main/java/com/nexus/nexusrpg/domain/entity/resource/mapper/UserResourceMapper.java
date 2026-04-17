package com.nexus.nexusrpg.domain.entity.resource.mapper;

import com.nexus.nexusrpg.domain.entity.resource.controller.dto.UserResourceDTO;
import com.nexus.nexusrpg.domain.entity.resource.controller.dto.UserResourceRefDTO;
import com.nexus.nexusrpg.domain.entity.resource.controller.dto.URExecutionDTO;
import com.nexus.nexusrpg.domain.entity.resource.model.UserResource;
import com.nexus.nexusrpg.domain.entity.resource.model.UserResourceExecution;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserResourceMapper {

    @Mapping(target = ".", source = "resource")
    UserResourceDTO toDTO(UserResource userResource);

    @Mapping(target = ".", source = "resource")
    UserResourceRefDTO toReferenceDTO(UserResource userResource);
}
