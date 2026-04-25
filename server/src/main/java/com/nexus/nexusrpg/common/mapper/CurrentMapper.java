package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.dto.EntityStaticReference;
import com.nexus.nexusrpg.common.state.State;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class CurrentMapper<T extends State> implements Mapper<List<T>, EntityStaticReference>{

    private final StaticReferenceMapper<T> referenceMapper;

    @Override
    public EntityStaticReference map(List<T> uEntities) {
        return uEntities.stream()
                .filter(T::isCurrent)
                .findFirst()
                .map(referenceMapper::map)
                .orElse(null);
    }
}
