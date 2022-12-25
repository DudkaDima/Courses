package com.dudka.courses.dto;

import com.dudka.courses.entity.Person;

import java.util.Objects;

public class PersonDto {
    private String login;
    private String name;
    private String surname;

    public PersonDto(Person person){
        login = person.getLogin();
        name = person.getName();
        surname = person.getSurname();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDto)) return false;
        PersonDto personDto = (PersonDto) o;
        return getLogin().equals(personDto.getLogin()) && getName().equals(personDto.getName()) && getSurname().equals(personDto.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getName(), getSurname());
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
