package com.nexus.nexusrpg.common.entity;

import com.nexus.nexusrpg.common.entity.interfaces.Initializable;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@RequiredArgsConstructor
public abstract class InitEntity<A, B> implements Initializable {

    private final JpaRepository<A, ?> baseRepository;
    private final JpaRepository<B, ?> relationRepository;

    @Override
    public void initialize(User user) {

        var baseEntities = baseRepository.findAll();

        var relations = baseEntities.stream()
                .map(base -> mapToRelation(user, base))
                .toList();

        relationRepository.saveAll(relations);
    }

    protected abstract B mapToRelation(User user, A baseEntity);
}