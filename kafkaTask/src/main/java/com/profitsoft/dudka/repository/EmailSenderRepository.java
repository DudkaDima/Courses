package com.profitsoft.dudka.repository;

import com.profitsoft.dudka.model.MailToSent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailSenderRepository extends MongoRepository<MailToSent, String> {
}
