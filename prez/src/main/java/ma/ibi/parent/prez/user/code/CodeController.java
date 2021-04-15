package ma.ibi.parent.prez.user.code;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.user.code.CodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api/codes")
@RequiredArgsConstructor
public class CodeController {

    Logger logger = LoggerFactory.getLogger(CodeController.class);

    private final CodeService codeService;


    @GetMapping
    public ResponseEntity getAll(){
        logger.info(" Get All Codes ");
        return ResponseEntity.ok(codeService.getAll());
    }


    @GetMapping("/newcode")
    public ResponseEntity<String> newCode(@RequestParam String email) {
        logger.info(" Generate New Code ");
        return codeService.generateCode(email)
                ? new ResponseEntity<>("ok", HttpStatus.CREATED)
                : new ResponseEntity<>("your email  is incorrect ", HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyCode(@RequestParam String email, @RequestParam Integer value) {
        logger.info(" verify Code ");
        return codeService.isCodeCorrect(email, value)
                ? new ResponseEntity<>("your code  is correct ", HttpStatus.FOUND)
                : new ResponseEntity<>("your code  is incorrect ", HttpStatus.BAD_REQUEST);
    }


}
