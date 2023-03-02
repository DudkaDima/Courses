package com.profitsoft.dudka.controller;

import com.profitsoft.dudka.service.serviceInterface.FamousPeopleCustomSearchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/profitsoft/rest/file")
@RequiredArgsConstructor
public class UploadingFileController {
    private final FamousPeopleCustomSearchingService famousPeopleCustomSearchingService;

    @PostMapping("/uploadZip")
    public String uploadDB(@RequestParam("file") MultipartFile file){
        famousPeopleCustomSearchingService.setUpDataBaseFromUploadedFile(file);
        return "OK";
    }

}
