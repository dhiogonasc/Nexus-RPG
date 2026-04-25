package com.nexus.nexusrpg.domain.mapper.reference.dynamics;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.common.mapping.ExecutionMapper;
import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.common.state.State;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class DynamicReferenceMapper<UEntity extends State> implements Mapper<UEntity, EntityDynamicReference> {
    protected final ExecutionMapper<UEntity> executionMapper;
}
