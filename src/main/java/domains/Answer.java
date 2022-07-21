package domains;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "quiz")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private boolean isCorrect;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Questions questions;
}
