package com.nexus.nexusrpg.domain.user.mapper.relation;

import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMissionMapper {

    UserMissionDTO toDTO(UserMission userMission);
    UserMissionReferenceDTO toReferenceDTO(UserMission userMission);
}
