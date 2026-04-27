package com.nexus.nexusrpg.domain.model;

import com.nexus.nexusrpg.common.feedback.AnswerComponent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"question\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_question_mission_order", columnNames = {"mission_id", "order"})
})
public class Question implements AnswerComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Column(name = "\"content\"", nullable = false, columnDefinition = "text")
    private String content;

    @Column(name = "\"explanation\"", nullable = false, columnDefinition = "text")
    private String explanation;

    @Column(name = "\"order\"", nullable = false)
    private Integer order;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alternative> alternatives;

    public Alternative getCorrect(){
        return alternatives.stream()
                .filter(Alternative::getIsCorrect)
                .findFirst()
                .orElse(null);
    }
}