package com.nexus.nexusrpg.domain.entity.mission.mapper;

import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionRefDTO;
import com.nexus.nexusrpg.domain.entity.mission.model.UserMission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMissionMapper {

    @Mapping(target = ".", source = "mission")
    UserMissionDTO toDTO(UserMission userMission);

    @Mapping(target = ".", source = "mission")
    UserMissionRefDTO toReferenceDTO(UserMission userMission);
}
