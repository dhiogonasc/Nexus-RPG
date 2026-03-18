package com.nexus.nexusrpg.repository;

import com.nexus.nexusrpg.exception.BusinessException;
import com.nexus.nexusrpg.model.relation.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findByUserEmail(String email);

    default UserProfile findByUserEmailOrThrow(String email){
        return findByUserEmail(email)
                .orElseThrow(() -> new BusinessException("Profile", "Nenhum usuário encontrado!", HttpStatus.NOT_FOUND));
    }
}
