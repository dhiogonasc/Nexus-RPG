package com.nexus.nexusrpg.domain.mapper.task;

import com.nexus.nexusrpg.common.mapping.ProgressMapper;
import com.nexus.nexusrpg.domain.mapper.reference.dynamics.MissionDynamicReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import org.springframework.stereotype.Component;

@Component
public class UMissionTaskMapper extends TaskMapper<UMission> {

    public UMissionTaskMapper(
            MissionDynamicReferenceMapper referenceMapper,
            ProgressMapper progressMapper) {
        super(referenceMapper, progressMapper);
    }
}
