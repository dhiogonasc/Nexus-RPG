package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.mapper.ReferenceMapper;
import com.nexus.nexusrpg.common.state.mapper.ExecutionMapper;
import com.nexus.nexusrpg.domain.controller.dto.mission.UMissionRDTO;
import com.nexus.nexusrpg.domain.repository.relation.UMissionRepository;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UMissionReferenceMapper
        extends ReferenceMapper<Mission, UMission, UMissionRDTO>
    implements ExecutionMapper<UMission>
{

    private final UMissionRepository uMissionRepository;

    @Override
    public UMissionRDTO toRefDTO(UMission uMission) {

        var mission =  uMission.getMission();

        return new UMissionRDTO(
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
