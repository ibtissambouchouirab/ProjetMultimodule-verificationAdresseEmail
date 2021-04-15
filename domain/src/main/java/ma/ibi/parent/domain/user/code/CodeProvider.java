package ma.ibi.parent.domain.user.code;


import ma.ibi.parent.domain.user.UserAggregate;

import java.util.List;
import java.util.Optional;

public interface CodeProvider {

    List<CodeAggregate> getAll();

    void saveCode(CodeAggregate aggregateCode);

    List<CodeAggregate> findByUserAndStatus(UserAggregate userAggregate, CodeStatus notVerified);

    void saveAll(List<CodeAggregate> expiredCodes);

    Optional<CodeAggregate> findByUserAndValueAndStatus(UserAggregate userAggregate, Integer codeValue, CodeStatus notVerified);
}
