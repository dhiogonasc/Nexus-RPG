package com.nexus.nexusrpg.domain.mapper.reference.dynamics;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.common.mapper.DynamicReferenceMapper;
import com.nexus.nexusrpg.common.mapper.ExecutionMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import org.springframework.stereotype.Component;

@Component
public class MissionDynamicReferenceMapper extends DynamicReferenceMapper<UMission> {

    public MissionDynamicReferenceMapper(ExecutionMapper<UMission> executionMapper) {
        super(executionMapper);
    }

    public EntityDynamicReference map(UMission uMission){
        var mission = uMission.getMission();
        return new EntityDynamicReference(
                mission.getId(),
                mission.getName(),
                mission.getDescription(),
                mission.getOrder(),
                executionMapper.map(uMission)
        );
    }
}
