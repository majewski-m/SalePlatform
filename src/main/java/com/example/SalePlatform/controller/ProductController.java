package com.example.SalePlatform.controller;

import com.example.SalePlatform.entity.Product;
import com.example.SalePlatform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
		product.setCreatedAt(LocalDateTime.now());

		return "add_form";
	}

	@PostMapping("/save")
	public String saveItem(@ModelAttribute("product") Product product) {

		productService.save(product);

		return "redirect:/sale/main";
	}
}
