package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.UserStatDTO;
import com.nexus.nexusrpg.model.relation.UserStat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserStatMapper {
    UserStatDTO toDTO(UserStat userStat);
}