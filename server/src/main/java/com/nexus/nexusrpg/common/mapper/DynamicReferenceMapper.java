package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.domain.model.relation.Statable;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class DynamicReferenceMapper<T extends Statable> implements Mapper<T, EntityDynamicReference> {
    protected final ExecutionMapper<T> executionMapper;
}
