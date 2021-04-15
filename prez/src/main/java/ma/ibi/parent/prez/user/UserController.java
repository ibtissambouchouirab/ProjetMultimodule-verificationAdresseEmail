package ma.ibi.parent.prez.user;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.user.UserAggregate;
import ma.ibi.parent.domain.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity getAll(){

        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserAggregate userAggregate){
        userService.addUser(userAggregate);
        return new ResponseEntity<>("Is CREATED ", HttpStatus.CREATED);
    }

    @PostMapping("/auth")
    public ResponseEntity<String> auth(@RequestParam String email, @RequestParam String password){
        UserAggregate user =  userService.authentification(email,password);
        if(user == null)
            return new ResponseEntity<>("verify your email and password", HttpStatus.CONFLICT);
        else {
            if (user.isEmailVerified())
                return new ResponseEntity<>(" Authentified ", HttpStatus.ACCEPTED);

            return new ResponseEntity<>(" verify your email ", HttpStatus.ACCEPTED);
        }
    }
}
