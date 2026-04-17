package com.nexus.nexusrpg.common.entity.interfaces;

public interface Progressable {
    Boolean getIsCurrent();

    void unlock();
    void complete();
    void update(long itens, long totalItens);
}
