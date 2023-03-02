package com.profitsoft.dudka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamousPeopleInfoByIsPepTrueDto {

    private String fullName;
    private boolean died;
    private boolean isPep;
}