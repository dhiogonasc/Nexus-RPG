package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.entity.RefMapper;
import com.nexus.nexusrpg.domain.controller.dto.mission.MissionRefDTO;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMExecutionRefDTO;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserMissionRepository;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionRefMapper extends RefMapper<Mission, UMission, MissionRefDTO> {

    private final UserMissionRepository repository;

    @Override
    public MissionRefDTO toRefDTO(UMission um) {

        var mission =  um.getMission();
        var execution = new UMExecutionRefDTO(um.getStatus());

        return new MissionRefDTO(
                mission.getId(),
                mission.getName(),
                execution
        );
    }

    @Override
    protected UMission findRelation(User user, Mission mission) {
        return repository.findByUserIdAndMissionIdOrThrow(user.getId(), mission.getId());
    }
}
