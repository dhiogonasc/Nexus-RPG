package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.common.state.State;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class DynamicReferenceMapper<T extends State> implements Mapper<T, EntityDynamicReference> {
    protected final ExecutionMapper<T> executionMapper;
}
