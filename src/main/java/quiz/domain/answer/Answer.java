package quiz.domain.answer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import quiz.domain.Auditable;
import quiz.domain.question.Question;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(schema = "question")
public class Answer extends Auditable {

    @Column(nullable = false)
    private String text;

    @Builder.Default
    private boolean correct = false;

    @ManyToOne
    private Question question;
}
