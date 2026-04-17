package com.nexus.nexusrpg.common.entity.interfaces;

import java.math.BigDecimal;

public interface Progressable {
    Boolean getIsCurrent();
    void updateProgress(long itens, long totalItens);
}
