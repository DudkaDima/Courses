package com.dudka.courses.service;

import com.dudka.courses.entity.Person;

import java.util.Optional;

public interface PersonService {
    public Optional<Person> findByLogin(String s);
}
