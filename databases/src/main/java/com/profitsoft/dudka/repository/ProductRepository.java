package com.profitsoft.dudka.repository;

import com.profitsoft.dudka.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p INNER JOIN p.type t WHERE p.productName = :#{#productName} AND t.typeName = :#{#typeName}")
    List<Optional<Product>> findByTypeAndName(@Param("productName") String productName, @Param("typeName") String typeName);

    List<Optional<Product>> findByProductName(String productName);

    List<Optional<Product>> findByYear(Long year);


}
