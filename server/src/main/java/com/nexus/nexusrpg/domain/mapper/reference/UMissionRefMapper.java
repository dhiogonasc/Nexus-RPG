package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.mapper.RefMapper;
import com.nexus.nexusrpg.common.state.mapper.ExecutionMapper;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionDTOR;
import com.nexus.nexusrpg.domain.repository.relation.UMissionRepository;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UMissionRefMapper
        extends RefMapper<Mission, UMission, UMissionDTOR>
    implements ExecutionMapper<UMission>
{

    private final UMissionRepository uMissionRepository;

    @Override
    public UMissionDTOR toRefDTO(UMission uMission) {

        var mission =  uMission.getMission();

        return new UMissionDTOR(
                mission.getId(),
                mission.getName(),
                mapExecution(uMission)
        );
    }

    @Override
    protected UMission findRelation(User user, Mission mission) {
        return uMissionRepository.findByUserIdAndEntityId(user.getId(), mission.getId());
    }
}
