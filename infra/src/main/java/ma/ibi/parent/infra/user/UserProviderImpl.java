package ma.ibi.parent.infra.user;

import ma.ibi.parent.domain.user.UserAggregate;
import ma.ibi.parent.domain.user.UserProvider;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserProviderImpl implements UserProvider  {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Adapter adapter;

    @Override
    public List<UserAggregate> getAll() {
        return adapter.adaptUserEntitiesToUserAggregates(userRepository.findAll());
    }


    @Override
    public void addUser(UserAggregate userAggregate) {
        userRepository.save(adapter.adaptUserAggregateToUserEntity(userAggregate));
    }

    @Override
    public UserAggregate anthentification(String email, String password) {
        return adapter.adaptUserEntityToUserAggregate(userRepository.findByEmailAndPassword(email, password).get());
    }

    @Override
    public UserAggregate findByEmail(String email) {
        if(userRepository.findByEmail(email).isPresent())
            return adapter.adaptUserEntityToUserAggregate(userRepository.findByEmail(email).get());
        return null;
    }


}
