package com.profitsoft.dudka.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.profitsoft.dudka.dto.SaveSentEmailDto;
import com.profitsoft.dudka.exception.MessageNotSentException;
import com.profitsoft.dudka.model.MailStatus;
import com.profitsoft.dudka.model.MailToSent;
import com.profitsoft.dudka.service.implementation.EmailSenderServiceImpl;
import com.profitsoft.dudka.smtpSender.SmtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.limit;
import static com.mongodb.client.model.Aggregates.match;


@Repository
@RequiredArgsConstructor
public class CustomSenderNotSentMailRepository {
    @Autowired
    private final MongoTemplate mongoTemplate;

    @Autowired
    private final SmtpService smtpService;

    @Autowired
    private final EmailSenderServiceImpl senderService;

    private List<MailToSent> getMailsWithError() {
        List<MailToSent> notSentMail = new ArrayList<>();
        MongoCollection<Document>  mongoCollection = mongoTemplate.getCollection("MailToSent");
        AggregateIterable<Document> result = mongoCollection.aggregate(
                Arrays.asList(
                        match(Filters.eq("status", "NOT_SENT")),
                        limit(10)));
        try(MongoCursor<Document> iterator = result.iterator()) {
            while(iterator.hasNext()) {
                Document document =  iterator.next();
                MailToSent mailToSent = MailToSent.builder()
                        ._id((String) document.get("_id"))
                        .fromEmail((String) document.get("fromEmail"))
                        .toEmail((String) document.get("toEmail"))
                        .errorMessage((String) document.get("errorMessage"))
                        .message((String) document.get("message"))
                        .subject((String) document.get("subject"))
                        .status(MailStatus.valueOf((String) document.get("status")))
                        .build();
                notSentMail.add(mailToSent);
            }
        }
        return notSentMail;
    }

    public void scheduledMailSender() {
        List<MailToSent> mailToSent = getMailsWithError();
        for(MailToSent mail : mailToSent) {
            SaveSentEmailDto saveMail = SaveSentEmailDto.builder()
                    .toEmail(mail.getToEmail())
                    .fromEmail(mail.getFromEmail())
                    .subject(mail.getSubject())
                    .message(mail.getMessage())
                    .build();
            try{

                smtpService.sendEmail(saveMail);
                senderService.saveSentEmail(saveMail);
            } catch (MessageNotSentException e) {
                senderService.saveFailedToSendMail(saveMail);
            }
        }


    }

}
