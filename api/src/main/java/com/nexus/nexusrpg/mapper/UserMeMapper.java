package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.response.UserResponseDTO;
import com.nexus.nexusrpg.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {
                UserMapper.class,
                LevelMapper.class,
                UserStatMapper.class
        }
)
public interface UserMeMapper {

    @Mapping(target = "user", source = ".")
    @Mapping(target = "level", source = "userStat.level")
    @Mapping(target = "stats", source = "userStat")
    UserResponseDTO toResponse(User user);
}
