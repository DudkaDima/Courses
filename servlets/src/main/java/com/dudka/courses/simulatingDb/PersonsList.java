package com.dudka.courses.simulatingDb;

import com.dudka.courses.dto.PersonDto;
import com.dudka.courses.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonsList {
    public static  List<Person> PERSON_LIST = new ArrayList<>();
    public static List<PersonDto> PERSON_DTO_LIST = new ArrayList<>();

    public static List<PersonDto> transferPersonListToDtoList(List<Person> persons) {

        return persons.stream().map(PersonDto::new).collect(Collectors.toList());
    }

}
