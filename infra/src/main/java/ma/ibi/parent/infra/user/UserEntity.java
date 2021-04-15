package ma.ibi.parent.infra.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name="last_name")
    private String lastName;

    @Column(name="pseudo_name")
    private String pseudoName;

    private String email;

    private String password;

    @Column(name="is_email_verified")
    private Boolean isEmailVerified;
}
