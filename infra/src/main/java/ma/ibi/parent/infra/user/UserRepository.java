package ma.ibi.parent.infra.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmailAndPassword(String email, String password);

    Optional<UserEntity> findByEmail(String email);

}
