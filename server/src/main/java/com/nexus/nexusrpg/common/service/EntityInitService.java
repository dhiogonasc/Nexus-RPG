package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@RequiredArgsConstructor
public abstract class EntityInitService<Entity, UserEntity> implements Initializable {

    private final JpaRepository<Entity, Long> baseRepository;
    private final JpaRepository<UserEntity, Long> relationRepository;

    @Override
    public void initialize(User user) {

        var baseEntities = baseRepository.findAll();

        var relations = baseEntities.stream()
                .map(base -> initRelation(user, base))
                .toList();

        relationRepository.saveAll(relations);
    }

    protected abstract UserEntity initRelation(User user, Entity baseEntity);
}