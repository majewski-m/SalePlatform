package com.example.SalePlatform.service;

import com.example.SalePlatform.entity.Product;
import com.example.SalePlatform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public void save (Product product) {
		productRepository.save(product);
	}

}
