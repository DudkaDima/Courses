package com.profitsoft.dudka.kafkaListener;


import com.profitsoft.dudka.dto.MessageDetailsDto;
import com.profitsoft.dudka.dto.SaveSentEmailDto;
import com.profitsoft.dudka.exception.MessageNotSentException;
import com.profitsoft.dudka.service.EmailSenderService;
import com.profitsoft.dudka.smtpSender.SmtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetEmailListener {
    @Autowired
    private final EmailSenderService senderService;
    @Autowired
    private final SmtpService smtpService;

    @KafkaListener(topics = "${topic.name}")
    public void sendEmailAndSave(SaveSentEmailDto dto) {
        try{
            smtpService.sendEmail(dto);
            senderService.saveSentEmail(dto);
        } catch (MessageNotSentException e) {
            senderService.saveFailedToSendMail(dto);
        }
    }
}
