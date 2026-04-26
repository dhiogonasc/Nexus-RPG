package com.nexus.nexusrpg.domain.repository;

import com.nexus.nexusrpg.domain.model.relation.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Answer, Long> {
}
