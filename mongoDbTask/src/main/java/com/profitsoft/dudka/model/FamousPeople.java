package com.profitsoft.dudka.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


//TODO: Change the name of Document id MongoDb
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("famous_people")
public class FamousPeople {
    //TODO: Figure out of Photo

    @Id
    @JsonIgnore()
    private String _id;
    //name depending
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("also_known_as_uk")
    private String alsoKnownAsUk;
    @JsonProperty("patronymic_en")
    private String patronymicEn;
    @JsonProperty("full_name_en")
    private String fullNameEn;
    @JsonProperty("first_name_en")
    private String firstNameEn;
    @JsonProperty("last_name_en")
    private String lastNameEn;
    @JsonProperty("also_known_as_en")
    private String alsoKnownAsEn;
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
    @JsonProperty("is_pep")
    private boolean isPep;
    @JsonProperty("died")
    private boolean died;
    @JsonProperty("city_of_birth_uk")
    private String cityOfBirthUk;
    @JsonProperty("city_of_birth_en")
    private String cityOfBirthEn;
    //work
    @JsonProperty("type_of_official")
    private String typeOfOfficial;
    @JsonProperty("type_of_official_en")
    private String typeOfOfficialEn;
    @JsonProperty("last_job_title")
    private String lastJobTitle;
    @JsonProperty("last_workplace")
    private String lastWorkplace;
    @JsonProperty("last_workplace_en")
    private String lastWorkplaceEn;
    @JsonProperty("last_job_title_en")
    private String lastJobTitleEn;
    //termination
    @JsonProperty("reason_of_termination")
    private String reasonOfTermination;
    @JsonProperty("reason_of_termination_en")
    private String reasonOfTerminationEn;
    @JsonProperty("termination_date_human")
    private String terminationDateHuman;
    //reputation
    @JsonProperty("reputation_convictions_uk")
    private String reputationConvictionsUk;
    @JsonProperty("reputation_manhunt_uk")
    private String reputationManhuntUk;
    @JsonProperty("reputation_sanctions_uk")
    private String reputationSanctionsUk;
    @JsonProperty("reputation_crimes_uk")
    private String reputationCrimesUk;
    @JsonProperty("reputation_convictions_en")
    private String reputationConvictionsEn;
    @JsonProperty("reputation_crimes_en")
    private String reputationCrimesEn;
    @JsonProperty("reputation_manhunt_en")
    private String reputationManhuntEn;
    @JsonProperty("reputation_sanctions_en")
    private String reputationSanctionsEn;
    @JsonProperty("reputation_assets_en")
    private String reputationAssetsEn;
    @JsonProperty("reputation_assets_uk")
    private String reputationAssetsUk;
    //other
    @JsonProperty("url")
    private String url;
    @JsonProperty("wiki_uk")
    private String wikiUk;
    @JsonProperty("wiki_en")
    private String wikiEn;
    @JsonProperty("names")
    private String names;



    @JsonProperty("related_persons")
    private List<RelatedPerson> relatedPersons;

    @JsonProperty("related_companies")
    private List<RelatedCompany> relatedCompanies;

    @JsonProperty("declarations")
    private List<Declarations> declarations;

    @JsonProperty("related_countries")
    private List<RelatedCountries> relatedCountries;

    public List<RelatedPerson> getRelatedPersons() {
        if(relatedPersons==null || relatedPersons.isEmpty()) {
            return Collections.emptyList();
        }
        return relatedPersons;
    }

    public List<RelatedCompany> getRelatedCompanies() {
        if(relatedCompanies==null || relatedCompanies.isEmpty()) {
            return Collections.emptyList();
        }
        return relatedCompanies;
    }

    public List<Declarations> getDeclarations() {
        if(declarations==null || declarations.isEmpty()) {
            return Collections.emptyList();
        }
        return declarations;
    }

    public List<RelatedCountries> getRelatedCountries() {
        if(relatedCountries==null || relatedCountries.isEmpty()) {
            return Collections.emptyList();
        }
        return relatedCountries;
    }

    @Override
    public String toString() {
        return "FamousPeople{" +
                "photo='" + photo + '\'' +
                ", _id='" + _id + '\'' +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", full_name='" + fullName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", also_known_as_uk='" + alsoKnownAsUk + '\'' +
                ", patronymic_en='" + patronymicEn + '\'' +
                ", full_name_en='" + fullNameEn + '\'' +
                ", first_name_en='" + firstNameEn + '\'' +
                ", last_name_en='" + lastNameEn + '\'' +
                ", also_known_as_en='" + alsoKnownAsEn + '\'' +
                ", date_of_birth='" + dateOfBirth+ '\'' +
                ", is_pep=" + isPep +
                ", died=" + died +
                ", city_of_birth_uk='" + cityOfBirthUk + '\'' +
                ", city_of_birth_en='" + cityOfBirthEn + '\'' +
                ", type_of_official='" + typeOfOfficial + '\'' +
                ", type_of_official_en='" + typeOfOfficialEn + '\'' +
                ", last_job_title='" + lastJobTitle + '\'' +
                ", last_workplace='" + lastWorkplace + '\'' +
                ", last_workplace_en='" + lastWorkplaceEn + '\'' +
                ", last_job_title_en='" + lastJobTitleEn + '\'' +
                ", reason_of_termination='" + reasonOfTermination + '\'' +
                ", reason_of_termination_en='" + reasonOfTerminationEn + '\'' +
                ", termination_date_human='" + terminationDateHuman + '\'' +
                ", reputation_convictions_uk='" + reputationConvictionsUk + '\'' +
                ", reputation_manhunt_uk='" + reputationManhuntUk + '\'' +
                ", reputation_sanctions_uk='" + reputationSanctionsUk + '\'' +
                ", reputation_crimes_uk='" + reputationCrimesUk + '\'' +
                ", reputation_convictions_en='" + reputationConvictionsEn + '\'' +
                ", reputation_crimes_en='" + reputationCrimesEn + '\'' +
                ", reputation_manhunt_en='" + reputationManhuntEn+ '\'' +
                ", reputation_sanctions_en='" + reputationSanctionsEn + '\'' +
                ", reputation_assets_en='" + reputationAssetsEn + '\'' +
                ", url='" + url + '\'' +
                ", wiki_uk='" + wikiUk + '\'' +
                ", wiki_en='" + wikiEn + '\'' +
                ", names='" + names + '\'' +
                ", relatedPeople=" + relatedPersons +
                ", relatedCompanies=" + relatedCompanies +
                ", declarations=" + declarations +
                ", countries=" + relatedCountries +
                '}';
    }
}
