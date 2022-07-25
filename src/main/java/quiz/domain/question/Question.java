package quiz.domain.question;


import jakarta.persistence.*;
import lombok.*;
import quiz.domain.Auditable;
import quiz.domain.answer.Answer;
import quiz.domain.subject.Subject;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(schema = "question")
public class Question extends Auditable {

    private String question;

    private Integer ball;

    @ManyToOne
    private Subject subject;

    @Builder.Default
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private ArrayList<Answer> answers = new ArrayList<>();
}
