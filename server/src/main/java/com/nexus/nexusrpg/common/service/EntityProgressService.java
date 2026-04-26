package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.domain.model.relation.Orientable;
import com.nexus.nexusrpg.domain.model.relation.Statable;
import com.nexus.nexusrpg.domain.model.relation.Usable;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.UNLOCKED;

@Service
@RequiredArgsConstructor
public abstract class EntityProgressService<T extends Usable & Orientable & Statable> {

    protected abstract Optional<@NonNull T> findEntityByOrder(T current, int order);

    @Transactional
    public void processProgress(T current) {
        var user = current.getUser();
        user.addXp(current.getXpBonus());

        findEntityByOrder(current, current.getOrder())
                .filter(e -> e.getStatus() == UNLOCKED)
                .ifPresent(T::complete);

        findEntityByOrder(current, current.getOrder() + 1)
                .filter(e -> e.getStatus() == LOCKED)
                .ifPresent(next -> {
                    next.unlock();
                    onAfterUnlock(next);
                });
    }
    protected void onAfterUnlock(T entity) {}
}