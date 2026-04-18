package com.nexus.nexusrpg.user.mapper;

import com.nexus.nexusrpg.user.controller.dto.UserDTO;
import com.nexus.nexusrpg.user.model.User;


public class UserMapper{

    public static UserDTO toDTO(User user){

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getXp(),
                user.getOxygen()
        );
    }
}
