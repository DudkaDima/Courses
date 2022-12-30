package com.dudka.courses.service.personServiceImplementation;

import com.dudka.courses.entity.Person;
import com.dudka.courses.service.PersonService;
import com.dudka.courses.simulatingDb.PersonsList;

import java.util.Optional;

public class PersonServiceImpl implements PersonService {

    public Optional<Person> findByLogin(String login) {
        return PersonsList.PERSON_LIST.stream().filter(x -> x.getLogin().equals(login)).findFirst();
    }


}
