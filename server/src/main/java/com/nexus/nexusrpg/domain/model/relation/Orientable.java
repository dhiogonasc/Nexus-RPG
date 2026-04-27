package com.nexus.nexusrpg.domain.model.relation;

public interface Orientable {
    int getOrder();
    boolean isLast();

    default boolean isFirst(){
        return this.getOrder() == 1;
    };
}
