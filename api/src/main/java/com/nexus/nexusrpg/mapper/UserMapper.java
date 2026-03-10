package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.UserDTO;
import com.nexus.nexusrpg.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
}
