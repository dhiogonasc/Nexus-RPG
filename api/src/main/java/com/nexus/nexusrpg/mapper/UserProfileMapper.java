package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.UserProfileDTO;
import com.nexus.nexusrpg.model.relation.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfileDTO toDTO(UserProfile userProfile);
}
