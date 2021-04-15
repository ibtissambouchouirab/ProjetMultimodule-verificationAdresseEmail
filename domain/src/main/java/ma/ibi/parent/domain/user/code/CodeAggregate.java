package ma.ibi.parent.domain.user.code;

import lombok.*;
import ma.ibi.parent.domain.user.UserAggregate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodeAggregate {

    private Integer id;

    private UserAggregate user;

    private Integer value;

    private LocalDateTime creationDate;

    private LocalDateTime expirationDate;

    private CodeStatus codeStatus;

}
