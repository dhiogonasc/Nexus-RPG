package com.nexus.nexusrpg.domain.repository;

import com.nexus.nexusrpg.domain.model.relation.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
