package com.nexus.nexusrpg.common.state.mapper;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;
import com.nexus.nexusrpg.common.state.State;

public interface ExecutionMapper<T extends State> {

    default ExecutionDTO mapExecution(T entity){
        return new ExecutionDTO(
                entity.getStatus(),
                entity.isCurrent()
        );
    }
}
