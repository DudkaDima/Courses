package com.profitsoft.dudka.scheduledRepeatingMessage;


import com.profitsoft.dudka.service.CustomSenderNotSentMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class ScheduledRepeatingEmailSendingInCaseOfException {

    private final CustomSenderNotSentMailService scheduledSender;


    @Scheduled(timeUnit = TimeUnit.MINUTES, fixedRate = 5)
    public void sendingMessagesWithError () {
        scheduledSender.sendNotSentMessages();
    }
}
