package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.model.relation.UserProfile;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUserEmail(String email);

    default UserProfile findByUserEmailOrThrow(String email){
        return findByUserEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum stats encontrado para: " + email));
    }
}

