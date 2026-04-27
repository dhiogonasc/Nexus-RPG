package com.nexus.nexusrpg.domain.model;

import com.nexus.nexusrpg.common.feedback.AnswerComponent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"alternative\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_alternative_content", columnNames = {"question_id", "content"}),
        @UniqueConstraint(name = "uk_alternative", columnNames = {"question_id", "id"})
})
public class Alternative implements AnswerComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "\"content\"", nullable = false, columnDefinition = "text")
    private String content;

    @Builder.Default
    @Column(name = "\"is_correct\"", nullable = false)
    private Boolean isCorrect = false;
}