package domains.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.type.NumericBooleanConverter;

import java.net.InetAddress;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(schema = "users", name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Login login;

    @Column
    private Name name;

    @Column
    @Builder.Default
    @Convert(converter = GenderConverter.class)
    private Gender gender = Gender.Male;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @Convert(converter = NumericBooleanConverter.class)
    @Column
    @Builder.Default
    private boolean isDeleted = false;

    @Column
    private Blocking blocking;

    public enum Gender{
        Female,
        Male
    }

    static class GenderConverter implements AttributeConverter<Gender, Character>{

        @Override
        public Character convertToDatabaseColumn(Gender gender) {
            return switch (gender){
                case Male -> 'M';
                case Female -> 'F';
            };
        }

        @Override
        public Gender convertToEntityAttribute(Character character) {
            return switch (character){
                case 'M' -> Gender.Male;
                case 'F' -> Gender.Female;
                default -> null;
            };
        }
    }
}
