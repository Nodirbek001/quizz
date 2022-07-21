package domains.user;

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

    private Timestamp firstAttempt;

    private Timestamp blockedUntil;
}
