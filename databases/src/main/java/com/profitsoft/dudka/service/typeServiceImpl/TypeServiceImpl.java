package com.profitsoft.dudka.service.typeServiceImpl;

import com.profitsoft.dudka.model.Type;
import com.profitsoft.dudka.repository.TypeRepository;
import com.profitsoft.dudka.service.serviceInterfaces.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }
}
