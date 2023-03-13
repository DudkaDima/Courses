package com.profitsoft.dudka.controller;

import com.profitsoft.dudka.model.MailToSent;
import com.profitsoft.dudka.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/profitsoft/rest")
public class CheckMailController {

    @Autowired
    private final EmailSenderService senderService;

    @GetMapping("/getSavedMail")
    public ResponseEntity<Optional<MailToSent>> findById(@RequestParam(name = "id") String id) {
        return  ResponseEntity.ok(senderService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MailToSent>> findAll() {
        return ResponseEntity.ok(senderService.findAll());
    }


}
