package com.nexus.nexusrpg.domain.model.relation;

import com.nexus.nexusrpg.domain.model.relation.execution.Executable;

public interface Statable extends Executable, Rewardable {
    boolean isCurrent();
}
