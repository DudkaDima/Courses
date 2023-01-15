package com.profitsoft.dudka.service.productServiceImpl;

import com.profitsoft.dudka.model.Product;
import com.profitsoft.dudka.pagination.ProductResponse;
import com.profitsoft.dudka.repository.ProductRepository;
import com.profitsoft.dudka.service.serviceInterfaces.ProductService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectWriter;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Optional<Product>> findByTypeAndName(String name, String typeName, int page) {

        return ProductResponse.pageableProduct(productRepository.findByTypeAndName(name, typeName), page);
    }

    @Override
    public Product saveOrUpdate(Product product) {

        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Optional<Product>> getByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Optional<Product>> getByYear(Long year) {
        return productRepository.findByYear(year);
    }
}
