package com.nexus.nexusrpg.common.entity.interfaces;

public interface Progressable {

    void unlock();
    void complete();
    void update(long itens, long totalItens);
}
