package com.nexus.nexusrpg.domain.model.relation;

import com.nexus.nexusrpg.domain.model.Alternative;
import com.nexus.nexusrpg.domain.model.Question;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "response", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_response", columnNames = {"attempt_id", "question_id"})
})
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attempt_id", nullable = false)
    private Attempt attempt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alternative_id", nullable = false)
    private Alternative alternative;
}