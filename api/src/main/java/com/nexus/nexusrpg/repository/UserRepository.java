package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.model.entity.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);


    Optional<User> findByEmail(String email);

    default User findByEmailOrThrow(String email) {
        return findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado para: " + email));
    }

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.userStat us LEFT JOIN FETCH us.level l WHERE u.email = :email")
    Optional<User> findByEmailWithStats(@Param("email") String email);

    default User findByEmailWithStatsOrThrow(String email){
        return findByEmailWithStats(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado para: " + email));
    };
}
