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

public class RelatedCompany {

    @JsonProperty("relationship_type_en")
    private String relationshipTypeEn;
    @JsonProperty("to_company_short_en")
    private String toCompanyShortEn;
    @JsonProperty("date_established")
    private String dateEstablished;
    @JsonProperty("to_company_edrpou")
    private String toCompanyEdrPou;
    @JsonProperty("to_company_founded")
    private String toCompanyFounded;
    @JsonProperty("date_finished")
    private String dateFinished;
    @JsonProperty("to_company_is_state")
    private boolean toCompanyIsState;
    @JsonProperty("share")
    private double share;
    @JsonProperty("date_confirmed")
    private String dateConfirmed;
    @JsonProperty("to_company_uk")
    private String toCompanyUk;
    @JsonProperty("to_company_short_uk")
    private String toCompanyShortUk;
    @JsonProperty("to_company_en")
    private String toCompanyEn;
    @JsonProperty("relationship_type_uk")
    private String relationshipTypeUk;

    @Override
    public String toString() {
        return "RelatedCompany{" +
                "relationship_type_en='" + relationshipTypeEn + '\'' +
                ", to_company_short_en='" + toCompanyShortEn + '\'' +
                ", date_established='" + dateEstablished + '\'' +
                ", to_company_edrpou='" + toCompanyEdrPou + '\'' +
                ", to_company_founded='" + toCompanyFounded + '\'' +
                ", date_finished='" + dateFinished + '\'' +
                ", to_company_is_state=" + toCompanyIsState +
                ", share=" + share +
                ", date_confirmed='" + dateConfirmed + '\'' +
                ", to_company_uk='" + toCompanyUk + '\'' +
                ", to_company_short_uk='" + toCompanyShortUk + '\'' +
                ", to_company_en='" + toCompanyEn + '\'' +
                ", relationship_type_uk='" + relationshipTypeUk + '\'' +
                '}';
    }
}
