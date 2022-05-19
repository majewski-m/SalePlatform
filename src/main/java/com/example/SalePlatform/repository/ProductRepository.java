package com.example.SalePlatform.repository;

import com.example.SalePlatform.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
