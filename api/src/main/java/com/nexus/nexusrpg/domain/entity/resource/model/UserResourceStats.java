package com.nexus.nexusrpg.domain.entity.resource.model;

import com.nexus.nexusrpg.common.entity.enums.EntityStatus;
import com.nexus.nexusrpg.common.entity.interfaces.Progressable;
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
import java.time.LocalDateTime;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserResourceStats implements Progressable {

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "\"status\"", nullable = false, columnDefinition = "entity_status")
    private EntityStatus status = LOCKED;

    @Builder.Default
    @Column(name = "\"is_accessible\"", nullable = false)
    private Boolean isAccessible = false;

    @Builder.Default
    @Column(name = "\"is_current\"", nullable = false)
    private Boolean isCurrent = false;

    @Builder.Default
    @Column(name = "\"progress\"", nullable = false, columnDefinition = "progress")
    private BigDecimal progress = BigDecimal.ZERO;

    @Column(name = "\"collected_at\"")
    private LocalDateTime collectedAt;

    public void unlock() {
        this.status = UNLOCKED;
        this.isAccessible = true;
        this.isCurrent = true;
    }

    public void collect(){
        this.status = COMPLETED;
        this.isCurrent = false;
        this.collectedAt = LocalDateTime.now();
    }
}
