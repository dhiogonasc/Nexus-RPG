package com.nexus.nexusrpg.domain.user.mapper;

import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionAttemptDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.UserDTO;
import com.nexus.nexusrpg.domain.level.mapper.LevelMapper;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserMissionAttempt;
import org.mapstruct.*;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring", uses = {
        LevelMapper.class
})
public interface UserMapper {

    UserDTO toDTO(User user);

    UserMissionAttemptDTO toUserMissionAttemptDTO(UserMissionAttempt attempt);
}
