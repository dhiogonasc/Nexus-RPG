package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.entity.RefMapper;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionDTOR;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionExecDTOR;
import com.nexus.nexusrpg.domain.entity.mission.repository.UserMissionRepository;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UMissionRefMapper extends RefMapper<Mission, UMission, UMissionDTOR> {

    private final UserMissionRepository userMissionRepository;

    @Override
    public UMissionDTOR toRefDTO(UMission um) {

        var mission =  um.getMission();
        var execution = new UMissionExecDTOR(um.getStatus());

        return new UMissionDTOR(
                mission.getId(),
                mission.getName(),
                execution
        );
    }

    @Override
    protected UMission findRelation(User user, Mission mission) {
        return userMissionRepository.findByUserIdAndMissionIdOrThrow(user.getId(), mission.getId());
    }
}
