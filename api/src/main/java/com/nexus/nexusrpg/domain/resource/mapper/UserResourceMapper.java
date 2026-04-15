package com.nexus.nexusrpg.domain.resource.mapper;

import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceReferenceDTO;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResourceMapper {

    UserResourceDTO toDTO(UserResource userResource);
    UserResourceReferenceDTO toReferenceDTO(UserResource userResource);
}
