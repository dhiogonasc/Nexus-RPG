package com.nexus.nexusrpg.domain.entity.mission.mapper;

import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionStatsDTO;
import com.nexus.nexusrpg.domain.entity.mission.model.UserMission;
import com.nexus.nexusrpg.domain.entity.mission.model.UserMissionStats;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetStatsDTO;
import com.nexus.nexusrpg.domain.entity.planet.model.UserPlanetStats;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMissionMapper {

    UserMissionDTO toDTO(UserMission userMission);
    UserMissionReferenceDTO toReferenceDTO(UserMission userMission);
    UserMissionStatsDTO toStatsDTO(UserMissionStats stats);
}
