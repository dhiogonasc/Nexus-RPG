package com.nexus.nexusrpg.domain.model.relation;

import com.nexus.nexusrpg.domain.model.enums.EntityStatus;
import com.nexus.nexusrpg.domain.model.relation.execution.Execution;

public interface State extends Execution {
    EntityStatus getStatus();
    boolean isCurrent();
}
