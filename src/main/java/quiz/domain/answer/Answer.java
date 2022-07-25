package quiz.domain.answer;

import jakarta.persistence.*;
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;
}
