package com.profitsoft.dudka.controller;

import com.profitsoft.dudka.dto.FamousPeopleSearchByNameDto;
import com.profitsoft.dudka.dto.PopularPeopleDto;
import com.profitsoft.dudka.model.FamousPeople;
import com.profitsoft.dudka.service.serviceInterface.FamousPeopleCustomSearchingService;
import com.profitsoft.dudka.service.serviceInterface.FamousPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(value = "/api/profitsoft/rest")
public class Controller {

    FamousPeopleService famousPeopleService;
    FamousPeopleCustomSearchingService famousPeopleCustomSearchingService;

    @Autowired
    public Controller(FamousPeopleService famousPeopleService, FamousPeopleCustomSearchingService famousPeopleCustomSearchingService) {
        this.famousPeopleService = famousPeopleService;
        this.famousPeopleCustomSearchingService = famousPeopleCustomSearchingService;
    }


    @DeleteMapping(value = "/deleteAll")
    public void deleteAll() {
        famousPeopleService.deleteAll();
    }

    @GetMapping(value = "/getByPep")
    public ResponseEntity<List<PopularPeopleDto>> findByPep() {
        return ResponseEntity.ok(famousPeopleCustomSearchingService.findPeopleByIsPepTrue());
    }

    @PostMapping("/searchByName")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<FamousPeople>> search(@RequestBody FamousPeopleSearchByNameDto searchDto){
        return ResponseEntity.ok(famousPeopleCustomSearchingService.searchPeopleByFullName(searchDto));
    }

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
