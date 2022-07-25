package quiz.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.NumericBooleanConverter;

import java.sql.Timestamp;

@Builder(builderMethodName = "childBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public class Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Timestamp createdAt;

//    @Convert(converter = NumericBooleanConverter.class)
    @Column
    @Builder.Default
    private boolean deleted = false;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;
}
