package com.nexus.nexusrpg.domain.user.repository.relation;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public interface UserResourceRepository extends JpaRepository<UserResource, Long> {

    Optional<UserResource> findByUserIdAndResourceId(Long userId, Long resourceId);

    default UserResource findByUserIdAndResourceIdOrThrow(Long userId, Long resourceId){
        return findByUserIdAndResourceId(userId, resourceId)
                .orElseThrow(() -> new BusinessException("User - Resource", "Nenhum registro encontrado", HttpStatus.BAD_REQUEST));
    }
}
