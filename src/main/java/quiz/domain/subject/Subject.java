package quiz.domain.subject;

import jakarta.persistence.*;
import lombok.*;
import quiz.domain.Auditable;
import quiz.domain.Domain;
import quiz.domain.question.Question;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(schema = "question")
public class Subject extends Auditable implements Domain {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(targetEntity = Question.class, mappedBy = "subject",cascade = CascadeType.ALL)
    private ArrayList<Question> questions;
}
