package ma.ibi.parent.domain.user.code.mail;

import ma.ibi.parent.domain.user.code.CodeAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Qualifier("EmailSender")
    @Autowired
    public JavaMailSender emailSender;

    public void sendCodeByMail(CodeAggregate codeAggregate , String mail) {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail);
        message.setSubject("Code to verify your email");
        message.setText("Hello, your is code:"+codeAggregate.getValue());
        // Send Message!
        this.emailSender.send(message);
    }
}
