package com.profitsoft.dudka.service.serviceImpl;

import com.profitsoft.dudka.model.FamousPeople;
import com.profitsoft.dudka.repository.FamousPeopleRepository;
import com.profitsoft.dudka.service.serviceInterface.FamousPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FamousPeopleServiceImpl implements FamousPeopleService {

    FamousPeopleRepository famousPeopleRepository;

    @Autowired
    public FamousPeopleServiceImpl(FamousPeopleRepository famousPeopleRepository) {

        this.famousPeopleRepository = famousPeopleRepository;
    }

    @Override
    public void insert(List<FamousPeople> json) {
        famousPeopleRepository.insert(json);
    }

    @Override
    public List<FamousPeople> findAll() {
        return famousPeopleRepository.findAll();
    }

    @Override
    public void deleteAll() {
        famousPeopleRepository.deleteAll();
    }



}
