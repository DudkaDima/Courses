package com.profitsoft.dudka.smtpSender;


import com.profitsoft.dudka.dto.SaveSentEmailDto;
import com.profitsoft.dudka.exception.MessageNotSentException;
import com.profitsoft.dudka.model.MailToSent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class SmtpService {
    @Autowired
    private final JavaMailSender javaMailSender;

    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();


    @Async
    public void sendEmail(SaveSentEmailDto mailToSent) {

        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(mailToSent.getToEmail());
            mailMessage.setSubject(mailToSent.getSubject());
            mailMessage.setText(mailToSent.getMessage());
            mailMessage.setFrom(mailToSent.getFromEmail());
            javaMailSender.send(mailMessage);
        } catch (MailException e) {
            throw new MessageNotSentException("Message cannot be send, try again later");
        }
    }
}
