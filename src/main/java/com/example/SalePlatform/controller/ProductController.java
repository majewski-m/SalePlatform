package com.example.SalePlatform.controller;

import com.example.SalePlatform.entity.Product;
import com.example.SalePlatform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/sale")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/main")
	public String mainPage(Model model) {
		List<Product> products = productService.findAll();

		model.addAttribute("products", products);
		return "main_page";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Product product = new Product();

		model.addAttribute("product", product);
		model.addAttribute("now", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

		return "add_form";
	}

	@PostMapping("/save")
	public String saveItem(@ModelAttribute("product") Product product, @RequestParam("imageFile") MultipartFile imageFile) {

		System.out.println(imageFile.getOriginalFilename());

		System.out.println(Objects.equals(imageFile.getOriginalFilename(), ""));

		if (Objects.equals(imageFile.getOriginalFilename(), "")) {
			productService.save(product);

			return "redirect:/sale/main";
		}
		try {
			productService.saveImage(product, imageFile);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/sale/main";
		}
		product.setImage(imageFile.getOriginalFilename());
		productService.save(product);

		return "redirect:/sale/main";
	}
}
