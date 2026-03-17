package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.UserProfileDTO;
import com.nexus.nexusrpg.model.relation.UserStat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserStatMapper {
    UserProfileDTO toDTO(UserStat userStat);
}