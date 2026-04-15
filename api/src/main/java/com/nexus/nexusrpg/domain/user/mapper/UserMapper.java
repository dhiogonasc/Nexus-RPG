package com.nexus.nexusrpg.domain.user.mapper;

import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserAttemptDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.UserDTO;
import com.nexus.nexusrpg.domain.entity.level.mapper.LevelMapper;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.domain.user.model.relation.UserAttempt;
import org.mapstruct.*;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring", uses = {
        LevelMapper.class
})
public interface UserMapper {

    UserDTO toDTO(User user);

    UserAttemptDTO toUserMissionAttemptDTO(UserAttempt attempt);
}
