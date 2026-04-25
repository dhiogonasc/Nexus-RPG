package com.nexus.nexusrpg.domain.mapper.reference.statics;

import com.nexus.nexusrpg.common.dto.EntityStaticReference;
import com.nexus.nexusrpg.common.mapper.StaticReferenceMapper;
import com.nexus.nexusrpg.domain.model.relation.UMission;
import org.springframework.stereotype.Component;

@Component
public class MissionStaticReferenceMapper extends StaticReferenceMapper<UMission> {

    @Override
    public EntityStaticReference map(UMission uMission) {
        var mission = uMission.getMission();
        return new EntityStaticReference(
                mission.getId(),
                mission.getName(),
                mission.getDescription()
        );
    }
}
