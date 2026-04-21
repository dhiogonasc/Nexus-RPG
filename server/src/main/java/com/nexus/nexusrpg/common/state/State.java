package com.nexus.nexusrpg.common.state;

import com.nexus.nexusrpg.common.enums.EntityStatus;

public interface State extends Progression {
    EntityStatus getStatus();
    boolean isCurrent();
}
