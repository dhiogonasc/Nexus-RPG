package com.nexus.nexusrpg.domain.entity.mission.model;

import com.nexus.nexusrpg.domain.entity.alternative.model.Alternative;
import com.nexus.nexusrpg.domain.entity.question.model.Question;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_response\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_response_question", columnNames = {"attempt_id", "question_id"})
})
public class UserResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attempt_id", nullable = false)
    private UAttempt attempt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false, insertable = false, updatable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false),
            @JoinColumn(name = "alternative_id", referencedColumnName = "id", nullable = false)
    })
    private Alternative alternative;

    public boolean isHit() {
        return this.alternative.isCorrect();
    }
}