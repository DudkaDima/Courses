package com.profitsoft.dudka.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class FamousPeopleSearchByNameDto {

    private String firstName;
    private String lastName;
    private String patronymic;

}