package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.domain.model.relation.execution.Executable;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class DynamicReferenceMapper<T extends Executable> implements Mapper<T, EntityDynamicReference> {
    protected final ExecutionMapper<T> executionMapper;
}
