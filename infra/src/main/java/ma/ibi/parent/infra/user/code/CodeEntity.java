package ma.ibi.parent.infra.user.code;

import lombok.*;
import ma.ibi.parent.domain.user.code.CodeStatus;
import ma.ibi.parent.infra.user.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "CODE")
public class CodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private UserEntity user;

    private Integer value;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "experation_date")
    private LocalDateTime expirationDate;

    private CodeStatus status;


}
