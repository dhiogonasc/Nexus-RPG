package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.model.entity.User;
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

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.planets WHERE u.email = :email")
    Optional<User> findByEmailWithPlanets(String email);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.missions WHERE u.email = :email")
    Optional<User> findByEmailWithMissions(String email);
}
