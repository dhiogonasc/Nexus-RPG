package com.nexus.nexusrpg.model.entity;

import com.nexus.nexusrpg.model.relation.UserResponse;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"alternative\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_alternative_content", columnNames = {"question_id", "\"content\""}),
        @UniqueConstraint(name = "uk_alternative", columnNames = {"question_id", "id"})
})
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "\"content\"", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "\"feedback_tip\"", columnDefinition = "TEXT")
    private String feedbackTip;

    @Column(name = "\"is_correct\"", nullable = false)
    private Boolean isCorrect;
}
