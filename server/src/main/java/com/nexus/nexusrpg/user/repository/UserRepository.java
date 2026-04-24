package com.nexus.nexusrpg.user.repository;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrThrow(Long id){
        return findById(id)
                .orElseThrow(() -> new BusinessException("User", "Nenhum usuário encontrado!", NOT_FOUND));
    }

    boolean existsByEmail(String email);

    default User findByEmailOrThrow(String email){
        return findByEmail(email)
                .orElseThrow(() -> new BusinessException("User", "Nenhum usuário encontrado!", NOT_FOUND));
    }

    Optional<User> findByEmail(String email);
}
