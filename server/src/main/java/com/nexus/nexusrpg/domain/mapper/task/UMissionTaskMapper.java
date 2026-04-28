package com.nexus.nexusrpg.domain.mapper.task;

import com.nexus.nexusrpg.common.mapping.ProgressMapper;
import com.nexus.nexusrpg.domain.mapper.reference.ReferenceMapper;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import org.springframework.stereotype.Component;

@Component
public class UMissionTaskMapper extends TaskMapper<Mission, UMission> {

    public UMissionTaskMapper(
            ReferenceMapper<Mission, UMission> referenceMapper,
            ProgressMapper progressMapper) {
        super(referenceMapper, progressMapper);
    }
}
