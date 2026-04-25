package com.nexus.nexusrpg.domain.mapper.current;

import com.nexus.nexusrpg.common.dto.EntityStaticReference;
import com.nexus.nexusrpg.common.state.State;
import com.nexus.nexusrpg.domain.mapper.reference.statics.StaticReferenceMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class CurrentMapper<UEntity extends State> {

    private final StaticReferenceMapper<UEntity> referenceMapper;

    public EntityStaticReference map(List<UEntity> uEntities) {
        return uEntities.stream()
                .filter(UEntity::isCurrent)
                .findFirst()
                .map(referenceMapper::map)
                .orElse(null);
    }
}
