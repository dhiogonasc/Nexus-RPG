package com.nexus.nexusrpg.domain.mission.mapper;

import com.nexus.nexusrpg.domain.mission.controller.dto.MissionDTO;
import com.nexus.nexusrpg.domain.mission.controller.dto.MissionReferenceDTO;
import com.nexus.nexusrpg.domain.mission.model.Mission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MissionMapper {

    MissionDTO toDTO(Mission mission);
    MissionReferenceDTO toReferenceDTO(Mission mission);
}
