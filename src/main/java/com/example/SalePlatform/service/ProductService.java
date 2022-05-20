package com.example.SalePlatform.service;

import com.example.SalePlatform.entity.Product;
import com.example.SalePlatform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

	public void saveImage(Product product, MultipartFile imageFile) throws Exception {
		Path currentPath = Paths.get("");
		Path absolutePath = currentPath.toAbsolutePath();
		String imagePath = (absolutePath + "/src/main/resources/static/images/");
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(imagePath + imageFile.getOriginalFilename());
		product.setImage(path + "");
		System.out.println(product.getImage());
		Files.write(path, bytes);
	}

}
