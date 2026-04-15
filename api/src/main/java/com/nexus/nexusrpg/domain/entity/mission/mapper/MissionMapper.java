package com.nexus.nexusrpg.domain.entity.mission.mapper;

import com.nexus.nexusrpg.domain.entity.mission.controller.dto.MissionDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.MissionReferenceDTO;
import com.nexus.nexusrpg.domain.entity.mission.model.Mission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MissionMapper {

    MissionDTO toDTO(Mission mission);
    MissionReferenceDTO toReferenceDTO(Mission mission);
}
