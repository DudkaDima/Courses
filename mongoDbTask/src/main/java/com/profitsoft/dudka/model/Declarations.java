package com.profitsoft.dudka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Declarations {
    @JsonProperty("position_en")
    private String positionEn;
    @JsonProperty("url")
    private String url;
    @JsonProperty("income")
    private long income;
    @JsonProperty("region_uk")
    private String regionUk;
    @JsonProperty("office_en")
    private String officeEn;
    @JsonProperty("position_uk")
    private String positionUk;
    @JsonProperty("year")
    private int year;
    @JsonProperty("office_uk")
    private String officeUk;
    @JsonProperty("region_en")
    private String regionEn;
    @JsonProperty("family_income")
    private long familyIncome;


    @Override
    public String toString() {
        return "Declarations{" +
                "positionEn='" + positionEn + '\'' +
                ", url='" + url + '\'' +
                ", income=" + income +
                ", regionUk='" + regionUk + '\'' +
                ", officeEn='" + officeEn + '\'' +
                ", positionUk='" + positionUk + '\'' +
                ", year=" + year +
                ", officeUk='" + officeUk + '\'' +
                ", regionEn='" + regionEn + '\'' +
                ", familyIncome=" + familyIncome +
                '}';
    }
}
