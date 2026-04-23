package com.nexus.nexusrpg.domain.mapper.current;

import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import com.nexus.nexusrpg.common.state.State;
import com.nexus.nexusrpg.domain.mapper.reference.ReferenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
public abstract class CurrentMapper<Entity, UEntity extends State> {

    private final ReferenceMapper<Entity, UEntity> referenceMapper;

    public EntityReferenceDTO map(List<UEntity> uEntities) {
        return uEntities.stream()
                .filter(UEntity::isCurrent)
                .findFirst()
                .map(referenceMapper::toReferenceDTO)
                .orElse(null);
    }
}
