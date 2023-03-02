package com.profitsoft.dudka.repository;

import com.profitsoft.dudka.model.FamousPeople;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamousPeopleRepository extends MongoRepository<FamousPeople, String> {

}
