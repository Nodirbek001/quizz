package quiz.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Embeddable
public class Name {

    @Column
    private String firstname;

    @Column
    private String middleName;

    @Column
    private String lastname;
}
