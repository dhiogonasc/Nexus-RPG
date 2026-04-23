package com.nexus.nexusrpg.domain.mapper.current;

import com.nexus.nexusrpg.domain.mapper.reference.ReferenceMapper;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import org.springframework.stereotype.Component;

@Component
public class CurrentMissionMapper extends CurrentMapper<Mission, UMission>{
    public CurrentMissionMapper(ReferenceMapper<Mission, UMission> referenceMapper) {
        super(referenceMapper);
    }
}
