package com.profitsoft.dudka.service.implementation;

import com.profitsoft.dudka.repository.CustomSenderNotSentMailRepository;
import com.profitsoft.dudka.service.CustomSenderNotSentMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomSenderNotSentMailServiceImpl implements CustomSenderNotSentMailService {

    private final CustomSenderNotSentMailRepository sendingErrorMails;

    @Override
    public void sendNotSentMessages() {
        sendingErrorMails.scheduledMailSender();
    }

}
