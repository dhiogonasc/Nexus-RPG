package com.nexus.nexusrpg.domain.entity.mission.mapper;

import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserAttemptDTO;
import com.nexus.nexusrpg.domain.entity.mission.model.UserAttempt;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAttemptMapper {

    UserAttemptDTO toDTO(UserAttempt userAttempt);
}
