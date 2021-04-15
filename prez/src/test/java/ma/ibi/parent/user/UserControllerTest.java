package ma.ibi.parent.user;

import ma.ibi.parent.domain.user.UserAggregate;
import ma.ibi.parent.domain.user.UserService;
import ma.ibi.parent.prez.user.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@WebMvcTest(controllers = UserController.class)
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private UserService userService;

   /* @Test
    public void should_Get_All_User() throws  Exception{
       List< UserAggregate> userList = new ArrayList<>();
        given(userService.getAll()).willReturn(userList);
        this.mockMvc.perform(get("/v1/api/users"))
                .contentType("application/json")
                .andExpect(status().isOk()) ;
    }

    @Test
    public void should_Add_User() throws  Exception{
         UserAggregate user = new UserAggregate();
        userService.addUser(user);
        this.mockMvc.perform(post("/v1/api/users/add" , user))
                .contentType("application/json")
                .andExpect(status().isOk());
    }

    @Test
    public void should_Auth_User() throws  Exception{
        String email = "ibi.email@test.ib";
        String passwod = "Pass@2345";
        given(userService.authentification(email,passwod)).willReturn(UserAggregate.builder().build());
        this.mockMvc.perform(post("/v1/api/users/auth" , email ,passwod))
                .contentType("application/json")
                .andExpect(status().isOk());
    }

    */


}
