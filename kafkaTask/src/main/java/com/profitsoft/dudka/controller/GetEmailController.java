package com.profitsoft.dudka.controller;

import com.profitsoft.dudka.dto.MessageDetailsDto;
import com.profitsoft.dudka.dto.SaveSentEmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/profitsoft/rest")
public class GetEmailController {
    @Value(value = "${kafka.topic.sendEmail}")
    private String mailSenderTopic;

    private final KafkaOperations<String, SaveSentEmailDto> kafkaOperations;

    @PostMapping("/getEmail")
    public void receiveMail(@RequestBody SaveSentEmailDto dto) {
        kafkaOperations.send(mailSenderTopic, dto);
    }




}
