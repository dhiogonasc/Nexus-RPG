package com.nexus.nexusrpg.common.dto;

import com.nexus.nexusrpg.common.task.ExecutionDTO;

public interface DynamicReference extends StaticReference{
    ExecutionDTO execution();
}
