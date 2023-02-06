package com.dudka.profitsoft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dudka.profitsoft.examples.Example;

@RestController
@RequestMapping(value = "/math")
public class Controller {


    @GetMapping(value = "/examples")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity getExamples(@RequestParam(name = "count") Integer count) {
        return ResponseEntity.ok(Example.buildExamples(count));
    }
}