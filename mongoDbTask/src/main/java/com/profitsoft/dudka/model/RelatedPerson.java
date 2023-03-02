package com.profitsoft.dudka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RelatedPerson {

    @JsonProperty("relationship_type")
    private String relationshipType;
    @JsonProperty("relationship_type_en")
    private String relationshipTypeEn;
    @JsonProperty("date_established")
    private String dateEstablished;
    @JsonProperty("person_en")
    private String personEn;
    @JsonProperty("person_uk")
    private String personUk;
    @JsonProperty("date_confirmed")
    private String dateConfirmed;

    @JsonProperty("is_pep")
    private boolean isPep;
    @JsonProperty("date_finished")
    private String dateFinished;

    @Override
    public String toString() {
        return "RelatedPerson{" +
                "relationship_type='" + relationshipType + '\'' +
                ", relationship_type_en='" + relationshipTypeEn + '\'' +
                ", date_established=" + dateEstablished +
                ", person_en='" + personEn + '\'' +
                ", person_uk='" + personUk + '\'' +
                ", date_confirmed=" + dateConfirmed +
                ", is_pep=" + isPep +
                ", date_finished=" + dateFinished +
                '}';
    }
}
