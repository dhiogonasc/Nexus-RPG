package com.nexus.nexusrpg.domain.user.mapper;

import com.nexus.nexusrpg.common.entity.interfaces.Statable;

import java.util.List;
import java.util.function.Function;

public interface CurrentEntityMapper {

    default <E extends Statable, D> D mapCurrent(List<E> entities, Function<E, D> mapperFunction) {
        if (entities == null || entities.isEmpty()) {
            return null;
        }

        return entities.stream()
                .filter(e -> e.getStats() != null && Boolean.TRUE.equals(e.getStats().getIsCurrent()))
                .findFirst()
                .map(mapperFunction)
                .orElse(null);
    }
}
