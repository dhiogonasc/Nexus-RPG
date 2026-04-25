package com.nexus.nexusrpg.domain.mapper.task;

import com.nexus.nexusrpg.common.mapper.ProgressMapper;
import com.nexus.nexusrpg.domain.mapper.reference.dynamics.MissionDynamicReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import org.springframework.stereotype.Component;

@Component
public class MissionTaskMapper extends TaskMapper<UMission> {

    public MissionTaskMapper(
            MissionDynamicReferenceMapper referenceMapper,
            ProgressMapper progressMapper) {
        super(referenceMapper, progressMapper);
    }
}
