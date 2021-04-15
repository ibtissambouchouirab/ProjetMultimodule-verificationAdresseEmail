package ma.ibi.parent.domain.user.code;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.user.UserAggregate;
import ma.ibi.parent.domain.user.UserProvider;
import ma.ibi.parent.domain.user.UserService;
import ma.ibi.parent.domain.user.code.mail.MailService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeProvider codeProvider;

    private final UserProvider userProvider;

    private final UserService userService;

    private final MailService mailService;

    public List<CodeAggregate> getAll(){
        return codeProvider.getAll();
    }

    public Boolean generateCode(String email) {
        UserAggregate userAggregate = userProvider.findByEmail(email);
        if(userAggregate != null) {
            LocalDateTime creationDateTime = LocalDateTime.now();
            LocalDateTime expirationDateTime = creationDateTime.plusMinutes(30l);
            CodeAggregate codeAggregate = CodeAggregate.builder()
                    .value(20846)
                    .user(userAggregate)
                    .codeStatus(CodeStatus.NOT_VERIFIED)
                    .creationDate(creationDateTime)
                    .expirationDate(expirationDateTime).build();
            codeProvider.saveCode(codeAggregate);
            mailService.sendCodeByMail(codeAggregate, email);
            return true;
        }
        return false;
    }
    public void generateNewCode(String email){
        UserAggregate userAggregate = userProvider.findByEmail(email);
        List<CodeAggregate> expiredCodes = codeProvider.findByUserAndStatus(userAggregate,CodeStatus.NOT_VERIFIED)
                .stream().map(
                        code -> {
                            code.setCodeStatus(CodeStatus.EXPIRED);
                            return code;
                        }).collect(Collectors.toList());

        codeProvider.saveAll(expiredCodes);
        generateCode(email);
    }

    public boolean isCodeCorrect(String email, Integer codeValue) {
        UserAggregate userAggregate = userProvider.findByEmail(email);
        Optional<CodeAggregate> codeToVerify = codeProvider.findByUserAndValueAndStatus(userAggregate, codeValue, CodeStatus.NOT_VERIFIED);
        AtomicBoolean isCodeCorrect = new AtomicBoolean(false);
        codeToVerify.ifPresent(code -> {
            if (code.getExpirationDate().isAfter(LocalDateTime.now()))
            {
                code.setCodeStatus(CodeStatus.VERIFIED);
                codeProvider.saveCode(code);
                userService.setEmailIsVerified(userAggregate);
                isCodeCorrect.set(true);
            }
            code.setCodeStatus(CodeStatus.EXPIRED);
            codeProvider.saveCode(code);
        });

        return isCodeCorrect.get();
    }



}
