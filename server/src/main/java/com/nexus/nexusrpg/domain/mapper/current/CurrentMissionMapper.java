package com.nexus.nexusrpg.domain.mapper.current;

import com.nexus.nexusrpg.common.mapper.CurrentMapper;
import com.nexus.nexusrpg.common.mapper.StaticReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import org.springframework.stereotype.Component;

@Component
public class CurrentMissionMapper extends CurrentMapper<UMission> {
    public CurrentMissionMapper(StaticReferenceMapper<UMission> referenceMapper) {
        super(referenceMapper);
    }
}
