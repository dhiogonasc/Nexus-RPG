package com.nexus.nexusrpg.domain.model.relation.execution;

import com.nexus.nexusrpg.common.enums.EntityStatus;
import com.nexus.nexusrpg.common.state.Execution;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import static com.nexus.nexusrpg.common.enums.EntityStatus.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UPlanetExec implements Execution {

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "\"status\"", nullable = false, columnDefinition = "entity_status")
    private EntityStatus status = LOCKED;

    @Builder.Default
    @Column(name = "\"is_current\"", nullable = false)
    private Boolean isCurrent = false;

    @Override
    public void unlock() {
        this.status = UNLOCKED;
        this.isCurrent = true;
    }

    @Override
    public void complete() {
        this.status = COMPLETED;
        this.isCurrent = false;
    }
}