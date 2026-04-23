package com.nexus.nexusrpg.domain.repository;

import com.nexus.nexusrpg.domain.model.relation.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {
}
