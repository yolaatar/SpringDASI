package com.helloIftekhar.springJwt.repository;

import com.helloIftekhar.springJwt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String productName);
}
