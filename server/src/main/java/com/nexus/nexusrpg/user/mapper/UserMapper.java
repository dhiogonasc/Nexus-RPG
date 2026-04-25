package com.nexus.nexusrpg.user.mapper;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.user.controller.dto.UserDTO;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserDTO> {

    private final UProgressionMapper uProgressionMapper;

    @Override
    public UserDTO map(User user){
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getXp(),
                user.getOxygen(),
                uProgressionMapper.map(user)
        );
    }
}
