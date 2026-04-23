package com.nexus.nexusrpg.domain.repository;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.Alternative;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface AlternativeRepository extends JpaRepository<Alternative, Long> {

    default Alternative findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new BusinessException(
                        "Alternative",
                        "Nenhum registro encontrado",
                        NOT_FOUND)
                );
    }
}
