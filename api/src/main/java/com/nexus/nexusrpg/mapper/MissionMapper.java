package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.MissionDTO;
import com.nexus.nexusrpg.model.entity.Mission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MissionMapper {
    MissionDTO toDTO(Mission mission);
}
