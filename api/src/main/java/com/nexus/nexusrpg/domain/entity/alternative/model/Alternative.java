package com.nexus.nexusrpg.domain.entity.alternative.model;

import com.nexus.nexusrpg.domain.entity.question.model.Question;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"alternative\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_alternative_content", columnNames = {"question_id", "content"}),
        @UniqueConstraint(name = "uk_alternative", columnNames = {"question_id", "id"})
})
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "\"content\"", nullable = false, columnDefinition = "text")
    private String content;

    @Column(name = "\"feedback_tip\"", nullable = false, columnDefinition = "text")
    private String feedbackTip;

    @Builder.Default
    @Column(name = "\"is_correct\"", nullable = false)
    private Boolean isCorrect = false;

    public boolean isCorrect() {
        return Boolean.TRUE.equals(this.isCorrect);
    }
}