package com.profitsoft.dudka.controller;

import com.profitsoft.dudka.dto.SaveSentEmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/profitsoft/rest")
public class GetEmailController {
    @Value("${topic.name}")
    private String mailSenderTopic;

    private final KafkaOperations<String, SaveSentEmailDto> kafkaOperations;

    @PostMapping("/getEmail")
    public void receiveMail(@RequestBody SaveSentEmailDto dto) {
        kafkaOperations.send(mailSenderTopic, dto);
    }
}
