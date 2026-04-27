package com.nexus.nexusrpg.domain.model.relation.execution;

import com.nexus.nexusrpg.domain.model.enums.EntityStatus;
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

import java.math.BigDecimal;

import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.LOCKED;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UMissionExecution {

    private static final BigDecimal MISSION_COMPLETION_THRESHOLD = BigDecimal.valueOf(7);

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "\"status\"", nullable = false, columnDefinition = "entity_status")
    private EntityStatus status = LOCKED;

    @Builder.Default
    @Column(name = "\"is_current\"", nullable = false)
    private boolean current = false;

    @Column(name = "\"best_result\"", columnDefinition = "score")
    private BigDecimal bestResult;
}
