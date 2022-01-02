package com.bousnina.eyan.repositories;

import com.bousnina.eyan.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    @RestResource(path = "/selectedProducts")
    List<Product> findAllBySelectedIsTrue();

    @RestResource(path = "/productsByKeyword")
    List<Product> findByNameContains(@Param("mc") String mc);
}
