package quiz.domain.subject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    @OneToMany(mappedBy = "subject")
    private ArrayList<Question> questions;
}
