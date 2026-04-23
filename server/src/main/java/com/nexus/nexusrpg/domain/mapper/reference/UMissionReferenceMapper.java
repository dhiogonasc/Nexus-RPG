package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.mapping.state.ExecutionMapper;
import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.repository.relation.UserMissionRepository;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UMissionReferenceMapper extends ReferenceMapper<Mission, UMission> {

    private final ExecutionMapper<UMission> executionMapper;
    private final UserMissionRepository uMissionRepository;

    @Override
    public EntityReferenceDTO toReferenceDTO(UMission uMission) {

        var mission =  uMission.getMission();

        return new EntityReferenceDTO(
                mission.getId(),
                mission.getName(),
                executionMapper.map(uMission)
        );
    }

    @Override
     public UMission findRelation(User user, Mission mission) {
        return uMissionRepository.findByUserIdAndEntityId(user.getId(), mission.getId());
    }
}
