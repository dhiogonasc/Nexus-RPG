package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.UserDTO;
import com.nexus.nexusrpg.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        PlanetMapper.class,
        MissionMapper.class,
        LevelMapper.class
})
public interface UserMapper {
    UserDTO toDTO(User user);
}
