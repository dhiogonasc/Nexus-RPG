package com.nexus.nexusrpg.domain.entity.resource.mapper;

import com.nexus.nexusrpg.domain.entity.resource.controller.dto.UserResourceDTO;
import com.nexus.nexusrpg.domain.entity.resource.controller.dto.UserResourceReferenceDTO;
import com.nexus.nexusrpg.domain.entity.resource.controller.dto.UserResourceStatsDTO;
import com.nexus.nexusrpg.domain.entity.resource.model.UserResource;
import com.nexus.nexusrpg.domain.entity.resource.model.UserResourceStats;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResourceMapper {

    UserResourceDTO toDTO(UserResource userResource);
    UserResourceReferenceDTO toReferenceDTO(UserResource userResource);
    UserResourceStatsDTO toStatsDTO(UserResourceStats stats);
}
