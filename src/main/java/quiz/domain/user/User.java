package quiz.domain.user;

import jakarta.persistence.*;
import lombok.*;
import quiz.domain.Auditable;
import quiz.domain.Domain;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(callSuper = true)
@Entity
@Table(schema = "question", name = "users")
public class User extends Auditable implements Domain {

    @Column(nullable = false)
    private Login login;

    @Column
    @Builder.Default
    private Name name = new Name();

    @Column
    @Builder.Default
    @Convert(converter = GenderConverter.class)
    private Gender gender = Gender.Male;

    @Column
    @Builder.Default
    private Blocking blocking = new Blocking();

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Column
    @Builder.Default
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;

    @Column
    @Builder.Default
    private Score score = new Score();

    public enum Gender{
        Female('F'),
        Male('M');

        public final Character code;

        Gender(char code) {
            this.code = code;
        }
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

    public enum Status{
        DELETED(-2),
        BLOCKED(-1),
        ACTIVE(0);

        public final short code;

        Status(int code) {
            this.code = (short) code;
        }
    }

    static class StatusConverter implements AttributeConverter<Status, Short>{

        @Override
        public Short convertToDatabaseColumn(Status status) {
            return switch (status){
                case DELETED -> Status.DELETED.code;
                case BLOCKED -> Status.BLOCKED.code;
                case ACTIVE -> Status.ACTIVE.code;
            };
        }

        @Override
        public Status convertToEntityAttribute(Short code) {
            return switch (code){
                case -2 ->Status.DELETED;
                case -1->Status.BLOCKED;
                case 0->Status.ACTIVE;
                default -> null;
            };
        }
    }

    public enum Role{
        USER,
        ADMIN
    }
}
