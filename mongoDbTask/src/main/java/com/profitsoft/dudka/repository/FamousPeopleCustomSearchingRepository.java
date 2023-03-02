package com.profitsoft.dudka.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.profitsoft.dudka.dto.FamousPeopleSearchByNameDto;
import com.profitsoft.dudka.dto.PopularPeopleDto;
import com.profitsoft.dudka.model.FamousPeople;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.limit;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.sort;
import static org.springframework.data.mongodb.core.query.Criteria.where;


@Repository
@RequiredArgsConstructor
public class FamousPeopleCustomSearchingRepository {


    private final FamousPeopleRepository famousPeopleRepository;
    private final MongoTemplate mongoTemplate;

    @PostConstruct
    private void createOnStartUp() {
        if (!mongoTemplate.collectionExists(FamousPeople.class)) {
            mongoTemplate.createCollection(FamousPeople.class);
        } else {
            mongoTemplate.dropCollection(FamousPeople.class);
            mongoTemplate.createCollection(FamousPeople.class);
        }
    }

    public void saveAll(List<FamousPeople> famousPersonData) {
        famousPeopleRepository.saveAll(famousPersonData);
    }

    public void deleteAll() {
        famousPeopleRepository.deleteAll();
    }

    public List<FamousPeople> search(FamousPeopleSearchByNameDto searchDto) {

        Query mongoQuery = new Query();
        if (StringUtils.isNotBlank(searchDto.getFirstName())) {
            mongoQuery.addCriteria(where(FamousPeople.Fields.firstName)
                    .is(searchDto.getFirstName()));
        }
        if (StringUtils.isNotBlank(searchDto.getLastName())) {
            mongoQuery.addCriteria(where(FamousPeople.Fields.lastName)
                    .is(searchDto.getLastName()));
        }
        if (StringUtils.isNotBlank(searchDto.getPatronymic())) {
            mongoQuery.addCriteria(where(FamousPeople.Fields.patronymic)
                    .is(searchDto.getPatronymic()));
        }
        List<FamousPeople> famousPersonData = mongoTemplate
                .find(mongoQuery, FamousPeople.class);
        return famousPersonData;
    }

    public List<PopularPeopleDto> findPeopleByIsPepTrue() {
        List<PopularPeopleDto> mostPopularPeople = new ArrayList<>();
        MongoCollection<Document> mongoCollection = mongoTemplate
                .getCollection("famous_people");
        AggregateIterable<Document> result = mongoCollection.aggregate(
                Arrays.asList(
                        match(Filters.eq("isPep", true)),
                        group("$firstName",
                                Accumulators.sum("count", 1)),
                        sort(Sorts.descending("count")),
                        limit(10)));
        //map aggregation result to entity
        try (MongoCursor<Document> iterator = result.iterator()) {
            while (iterator.hasNext()) {
                Document document = iterator.next();
                PopularPeopleDto popularPeopleDto = PopularPeopleDto
                        .builder()
                        .firstName((String) document.get("_id"))
                        .amount(document.getInteger("count"))
                        .build();
                mostPopularPeople.add(popularPeopleDto);
            }
        }
        return mostPopularPeople;
    }

    @PreDestroy
    private void preDestroy() {
        mongoTemplate.dropCollection(FamousPeople.class);
    }
}