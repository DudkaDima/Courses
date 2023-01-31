package com.profitsoft.dudka.repository;

import com.profitsoft.dudka.model.Product;
import com.profitsoft.dudka.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
