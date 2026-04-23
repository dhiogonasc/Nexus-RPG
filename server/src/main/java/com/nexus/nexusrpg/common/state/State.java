package com.nexus.nexusrpg.common.state;

import com.nexus.nexusrpg.domain.model.enums.EntityStatus;

public interface State extends Execution {
    EntityStatus getStatus();
    boolean isCurrent();
}
