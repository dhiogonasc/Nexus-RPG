package com.nexus.nexusrpg.domain.model.relation;

import com.nexus.nexusrpg.domain.model.relation.execution.Executable;
import com.nexus.nexusrpg.user.model.User;

public interface Usable extends Executable, Rewardable {
    User getUser();
}
