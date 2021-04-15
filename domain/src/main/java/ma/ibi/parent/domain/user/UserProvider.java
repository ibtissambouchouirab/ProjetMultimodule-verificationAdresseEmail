package ma.ibi.parent.domain.user;


import java.util.List;
import java.util.Optional;

public interface UserProvider {

    List<UserAggregate> getAll();

    void addUser(UserAggregate userAggregate);

    UserAggregate anthentification(String email , String password);

    UserAggregate findByEmail(String email);
}
