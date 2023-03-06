package com.profitsoft.dudka.service.serviceInterface;

import com.profitsoft.dudka.model.FamousPeople;

import java.util.List;

public interface FamousPeopleService {

    void insert(List<FamousPeople> json);

    List<FamousPeople> findAll();

    void deleteAll();


}
