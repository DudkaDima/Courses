package com.profitsoft.dudka.controller;

import com.profitsoft.dudka.model.Product;
import com.profitsoft.dudka.service.serviceInterfaces.ProductService;
import com.profitsoft.dudka.service.serviceInterfaces.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/profitsoft/rest")
public class ApiController {
    private final ProductService productService;
    private final TypeService typeService;

    @Autowired
    public ApiController(ProductService productService, TypeService typeService) {
        this.productService = productService;
        this.typeService = typeService;
    }

    @GetMapping(value = "/products")
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping(value = "/byNameAndType")
    public ResponseEntity getProductByNameAndType(@RequestParam(name = "productName") String productName, @RequestParam(name = "typeName")
    String typeName, @RequestParam(name = "page") int page) {
        return ResponseEntity.ok(productService.findByTypeAndName(productName, typeName, page));

    }

    @DeleteMapping(value = "/deleteProduct")
    public void deleteProduct(@RequestParam(name = "id") Long id) {
        productService.delete(id);
    }

    @PostMapping(value = "/product")
    public Product saveProduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return product;
    }

    @PutMapping(value = "/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return product;
    }

    @GetMapping(value = "/productById")
    public ResponseEntity getById(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping(value = "/productByName")
    public ResponseEntity getByProductName(@RequestParam(name = "productName") String productName) {
        return ResponseEntity.ok(productService.getByProductName(productName));
    }

    @GetMapping(value = "/productByYear")
    public ResponseEntity getByYear(@RequestParam(name = "year") Long year) {
        return ResponseEntity.ok(productService.getByYear(year));
    }

    @GetMapping(value = "/types")
    public ResponseEntity getAllTypes() {
        return ResponseEntity.ok(typeService.findAll());
    }
}
