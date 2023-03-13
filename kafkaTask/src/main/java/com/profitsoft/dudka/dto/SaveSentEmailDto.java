package com.profitsoft.dudka.dto;

import com.profitsoft.dudka.model.MailStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Setter
@Getter
@Builder
public class SaveSentEmailDto {

    private String fromEmail;

    private String toEmail;

    private String subject;

    private String message;

}
