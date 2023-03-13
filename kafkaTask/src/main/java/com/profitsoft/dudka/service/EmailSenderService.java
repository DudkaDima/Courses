package com.profitsoft.dudka.service;

import com.profitsoft.dudka.dto.SaveSentEmailDto;
import com.profitsoft.dudka.model.MailToSent;

import java.util.List;
import java.util.Optional;

public interface EmailSenderService {
    String saveSentEmail(SaveSentEmailDto sentEmail);

    String saveFailedToSendMail(SaveSentEmailDto sentEmail);

    Optional<MailToSent> findById(String id);

    List<MailToSent> findAll();
}