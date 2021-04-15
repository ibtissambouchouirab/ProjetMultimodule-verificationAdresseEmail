package ma.ibi.parent.user;

import ma.ibi.parent.domain.user.UserAggregate;
import ma.ibi.parent.domain.user.UserProvider;
import ma.ibi.parent.domain.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.util.stream.Stream;

import static org.mockito.Mockito.when;


public class UserServiceTest {

    @Mock
    private UserProvider userProvider;;

    @InjectMocks
    private UserService userService;

    UserAggregate userAggregate = new UserAggregate(2,"name","lastname","pdname","ibi.game20@gmail.com","12A3456@8",false);

    @Test
    public void Should_return_User() {
        //when(userProvider.anthentification("ibi.email@test.ib", "Pass@2345")).thenReturn(userAggregate);
       //Assertions.assertThat(userService.authentification("ibi.email@test.ib", "Pass@2345")).isNotNull();
    }

    @Test
    public void Should_Add_User() throws Exception {
        //userService.addUser(userAggregate);
       // Mockito.verify(userProvider,Mockito.times(1)).addUser(Mockito.any(UserAggregate.class));
    }

    @Test
    public void Should_VerifyEmailr() throws Exception {
          userService.setEmailIsVerified(userAggregate);
          Mockito.verify(userProvider,Mockito.times(1)).addUser(Mockito.any(UserAggregate.class));
    }

    private static Stream<Arguments> provideUserToAdd(){
        return Stream.of(
                Arguments.of(UserAggregate.builder().build()),
                Arguments.of(UserAggregate.builder().id(1).build()),
                Arguments.of(UserAggregate.builder().id(2).name("name").build()),
                Arguments.of(UserAggregate.builder().id(3).name("name").lastName("lastName").build()),
                Arguments.of(UserAggregate.builder().id(4).name("name").lastName("lastName").pseudoName("pseudoName").build()),
                Arguments.of(UserAggregate.builder().id(5).name("name").lastName("lastName").pseudoName("pseudoName").email("ibi.game20@gmail.com").build()),
                Arguments.of(UserAggregate.builder().id(6).name("name").lastName("lastName").pseudoName("pseudoName").email("ibi.game20@gmail.com").password("12A3456@8").build()));
    }
}
