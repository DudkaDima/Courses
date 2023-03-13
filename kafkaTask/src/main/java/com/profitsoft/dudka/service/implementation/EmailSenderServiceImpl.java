package com.profitsoft.dudka.service.implementation;

import com.profitsoft.dudka.dto.SaveSentEmailDto;
import com.profitsoft.dudka.exception.MessageNotSentException;
import com.profitsoft.dudka.model.MailStatus;
import com.profitsoft.dudka.model.MailToSent;
import com.profitsoft.dudka.repository.EmailSenderRepository;
import com.profitsoft.dudka.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmailSenderServiceImpl implements EmailSenderService {

    private final EmailSenderRepository emailSenderRepository;

    @Autowired
    public EmailSenderServiceImpl(EmailSenderRepository emailSenderRepository) {
        this.emailSenderRepository = emailSenderRepository;
    }

    @Override
    public String saveSentEmail(SaveSentEmailDto sentEmail) {
        MailToSent mailToSent = new MailToSent();
        mailToSent.setFromEmail(sentEmail.getFromEmail());
        mailToSent.setToEmail(sentEmail.getToEmail());
        mailToSent.setMessage(sentEmail.getMessage());
        mailToSent.setSubject(sentEmail.getSubject());
        mailToSent.setStatus(MailStatus.SENT);
        mailToSent.setErrorMessage("");
        MailToSent saved = emailSenderRepository.save(mailToSent);
        return saved.getId();
    }

    @Override
    public String saveFailedToSendMail(SaveSentEmailDto sentEmail) {
        MailToSent mailToSent = new MailToSent();
        mailToSent.setFromEmail(sentEmail.getFromEmail());
        mailToSent.setToEmail(sentEmail.getToEmail());
        mailToSent.setMessage(sentEmail.getMessage());
        mailToSent.setSubject(sentEmail.getSubject());
        mailToSent.setStatus(MailStatus.NOT_SENT);
        mailToSent.setErrorMessage("Message cannot be send, try again later!");
        MailToSent saved = emailSenderRepository.save(mailToSent);
        return saved.getId();
    }

    @Override
    public Optional<MailToSent> findById(String id) {
        return emailSenderRepository.findById(id);
    }

    @Override
    public List<MailToSent> findAll() {
        return emailSenderRepository.findAll();
    }


    private MailToSent getOrThrow(String orderId) {
        return emailSenderRepository.findById(orderId)
                .orElseThrow(() -> new MessageNotSentException("Order with id '%s' not found".formatted(orderId)));
    }

}
