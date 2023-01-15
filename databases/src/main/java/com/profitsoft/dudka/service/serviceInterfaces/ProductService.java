package com.profitsoft.dudka.service.serviceInterfaces;

import com.profitsoft.dudka.model.Product;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Optional<Product>> findByTypeAndName(String firstName, String type, int page);

    public Product saveOrUpdate(Product product);


    public void delete(Long id);

    public List<Product> findAll();

    public Optional<Product> getById(Long id);

    public List<Optional<Product>> getByProductName(String name);

    public List<Optional<Product>> getByYear(Long year);

}
