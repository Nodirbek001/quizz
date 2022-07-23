package quiz.domain.user;

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
public class Score {

    @Builder.Default
    private Long points = 0L;
}
