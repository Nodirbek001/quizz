package domains;

import confic.HibernateConfigurer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "quiz")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @OneToMany(targetEntity = Answer.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "answer"
    )
    private List<Answer> answers;

    private int ball;

    @Enumerated(EnumType.STRING)
    private Language language;


    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateConfigurer.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        List<Answer> answers1= List.of(
                Answer.builder()
                        .text("1")
                        .isCorrect(true)
                        .build(),
                Answer.builder()
                        .text("2")
                        .isCorrect(false)
                        .build()
        );

        Questions questions=Questions.builder()
                .ball(10)
                .language(Language.UZ)
                .text("savol1").build();
       answers1.forEach(answer -> {
           answer.setQuestions(questions);
           session.persist(answer);
       });
        session.getTransaction().commit();
        session.close();
    }
    private enum Language {
        UZ, ENG, RU
    }

}
