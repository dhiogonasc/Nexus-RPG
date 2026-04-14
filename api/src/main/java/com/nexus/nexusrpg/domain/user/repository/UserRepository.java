package com.nexus.nexusrpg.domain.user.repository;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    default User findByEmailOrThrow(String email){
        return findByEmail(email)
                .orElseThrow(() -> new BusinessException("User", "Nenhum usuário encontrado!", HttpStatus.NOT_FOUND));
    }

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.planets WHERE u.id = :userId")
    Optional<User> findByUserIdWithPlanets(Long userId);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.resources WHERE u.id = :userId")
    Optional<User> findByUserIdWithResources(Long userId);
}
