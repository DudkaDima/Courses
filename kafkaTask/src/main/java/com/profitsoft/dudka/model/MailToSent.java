package com.profitsoft.dudka.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("MailToSent")
public class MailToSent {

    @Id
    private String _id;

    private String fromEmail;

    private String toEmail;

    private String subject;

    private String message;

    private MailStatus status;

    private String errorMessage;


}
