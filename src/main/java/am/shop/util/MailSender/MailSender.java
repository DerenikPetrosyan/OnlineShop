package am.shop.util.MailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

public class MailSender {

//    @Autowired
//    private JavaMailSender javaMailSender;
//
//
//    public void sendEmail(String toEmail, String subject, String body){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("derenikpetrosyan68@gmail.com");
//        message.setTo(toEmail);
//        message.setText(body);
//        message.setSubject(subject);
//
//        javaMailSender.send(message);
//
//    }
}
