package ma.ibi.parent.domain.user;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAggregate {

    private Integer id;

    private String name;

    private String lastName;

    private String pseudoName;

    private String email;

    private String password;

    private boolean emailVerified;
}
