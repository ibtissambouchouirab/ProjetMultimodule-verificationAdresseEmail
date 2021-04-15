package ma.ibi.parent.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService  {
    private final UserProvider userProvider;

    public List<UserAggregate> getAll(){

        return userProvider.getAll();
    }

    public  void  addUser( UserAggregate userAggregate){

        userProvider.addUser(userAggregate);

    }

    public UserAggregate authentification(String email , String password){

        return userProvider.anthentification(email,password);
    }

    public void setEmailIsVerified(UserAggregate userAggregate) {
        userAggregate.setEmailVerified(true);
        userProvider.addUser(userAggregate);
    }



}
