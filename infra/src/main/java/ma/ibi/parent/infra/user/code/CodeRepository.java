package ma.ibi.parent.infra.user.code;

import ma.ibi.parent.domain.user.code.CodeStatus;
import ma.ibi.parent.infra.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodeRepository extends JpaRepository<CodeEntity , Integer> {

    List<CodeEntity> findByUserAndStatus(UserEntity userEntity, CodeStatus notVerified);

    Optional<CodeEntity> findByUserAndValueAndStatus(UserEntity userEntity , Integer valuer ,CodeStatus notVerified );
}
