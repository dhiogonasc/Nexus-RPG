package com.nexus.nexusrpg.common.mapping.mapper;

import com.nexus.nexusrpg.common.dto.ExecutionDTO;
import com.nexus.nexusrpg.common.state.State;
import org.springframework.stereotype.Component;

@Component
public class ExecutionMapper<T extends State> {

    public ExecutionDTO map(T entity){
        return new ExecutionDTO(
                entity.getStatus(),
                entity.isCurrent()
        );
    }
}
