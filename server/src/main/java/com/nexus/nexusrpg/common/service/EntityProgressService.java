package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.domain.model.enums.EntityStatus;
import com.nexus.nexusrpg.domain.model.relation.Orientable;
import com.nexus.nexusrpg.domain.model.relation.Usable;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Consumer;

import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.UNLOCKED;

@Service
@RequiredArgsConstructor
public abstract class EntityProgressService<T extends Usable & Orientable> {

    @Transactional
    public void process(T current){
        handleCompletion(current);
        handleUnlock(current);
        updateUserStats(current);
    }

    private void updateUserStats(T current) {
        var user = current.getUser();
        user.addXp(current.getXpBonus());
    }

    private void handleCompletion(T current){
        handleProcess(
                current,
                current.getOrder(),
                UNLOCKED,
                T::complete
        );
    }

    private void handleUnlock(T current){
        handleProcess(
                current,
                current.getNextOrder(),
                LOCKED,
                next -> {
                    next.unlock();
                    onUnlock(next);
                }
        );
    }

    private void handleProcess(
            T current,
            int order,
            EntityStatus status,
            Consumer<T> action
    ) {
        findEntityByOrder(current, order)
                .filter(e -> e.getStatus() == status)
                .ifPresent(action);
    }

    protected abstract Optional<@NonNull T> findEntityByOrder(T current, int order);
    protected void onUnlock(T current){}
}