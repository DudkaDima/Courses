package com.profitsoft.dudka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RelatedCountries {

    @JsonProperty("date_established")
    private String dateEstablished;
    @JsonProperty("date_finished")
    private String dateFinished;
    @JsonProperty("date_confirmed")
    private String dateConfirmed;
    @JsonProperty("to_country_en")
    private String toCountryEn;
    @JsonProperty("to_country_uk")
    private String toCountryUk;
    @JsonProperty("relationship_type")
    private String relationshipType;

    @Override
    public String toString() {
        return "RelatedCountries{" +
                "dateEstablished='" + dateEstablished + '\'' +
                ", dateFinished='" + dateFinished + '\'' +
                ", dateConfirmed='" + dateConfirmed + '\'' +
                ", toCountryEn='" + toCountryEn + '\'' +
                ", toCountryUk='" + toCountryUk + '\'' +
                ", relationshipType='" + relationshipType + '\'' +
                '}';
    }
}
