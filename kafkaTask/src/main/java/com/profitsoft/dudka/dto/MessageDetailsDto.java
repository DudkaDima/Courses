package com.profitsoft.dudka.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.profitsoft.dudka.model.MailStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDetailsDto {

    private String _id;

    private String fromEmail;

    private String toEmail;

    private String subject;

    private String message;

    private MailStatus status;

    private String errorMessage;
}
