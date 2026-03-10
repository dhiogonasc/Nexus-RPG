package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.model.entity.UserStat;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserStatRepository extends JpaRepository<UserStat, Long> {
    Optional<UserStat> findByUserEmail(String email);

    default UserStat findByUserEmailOrThrow(String email){
        return findByUserEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum stats encontrado para: " + email));
    }
}
