package com.nexus.nexusrpg.domain.model.relation.execution;

import com.nexus.nexusrpg.domain.model.enums.EntityStatus;

public interface Executable {

    EntityStatus getStatus();
    void setStatus(EntityStatus status);

    boolean isCurrent();
    void setCurrent(boolean isCurrent);

    default void unlock() {
        if (getStatus() == EntityStatus.LOCKED) {
            setStatus(EntityStatus.UNLOCKED);
            setCurrent(true);
        }
    }

    default void complete() {
        setStatus(EntityStatus.COMPLETED);
        setCurrent(false);
    }
}
