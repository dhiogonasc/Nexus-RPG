package com.nexus.nexusrpg.domain.model.relation;

public interface Orientable {
    int getOrder();

    boolean isLast();

    default int getNextOrder() {
        return getOrder() + 1;
    }

    default boolean isFirst() {
        return getOrder() == 1;
    }
}