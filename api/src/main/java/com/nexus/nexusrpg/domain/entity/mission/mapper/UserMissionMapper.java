package com.nexus.nexusrpg.domain.entity.mission.mapper;

import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMissionMapper {

    UserMissionDTO toDTO(UserMission userMission);
    UserMissionReferenceDTO toReferenceDTO(UserMission userMission);
}
