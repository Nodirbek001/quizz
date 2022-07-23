package quiz.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Embeddable
public class Blocking {

    @Builder.Default
    private short attempt = 0;

    @Column(name = "first_attempt")
    private Timestamp firstAttempt;

    @Column(name = "blocked_until")
    private Timestamp blockedUntil;
}
