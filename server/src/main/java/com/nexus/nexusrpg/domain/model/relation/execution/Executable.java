package com.nexus.nexusrpg.domain.model.relation.execution;

import com.nexus.nexusrpg.domain.model.enums.EntityStatus;

public interface Executable {
    EntityStatus getStatus();
    boolean isCurrent();
    void unlock();
    void complete();
}
