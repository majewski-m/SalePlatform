package com.example.SalePlatform.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	private BigDecimal price;

	private int quantity;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;

	@ManyToOne()
	@JoinColumn(name = "seller_id")
	private User user;

	@OneToMany(mappedBy = "product")
	private Set<Sale> sales = new HashSet<Sale>();


	public Product() {
	}

	public Product(String name, String description, BigDecimal price, int quantity, LocalDateTime createdAt, LocalDate endDate, User user) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.createdAt = createdAt;
		this.endDate = endDate;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Sale> getSales() {
		return sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", quantity=" + quantity +
				", createdAt=" + createdAt +
				", endDate=" + endDate +
				", user=" + user +
				", sales=" + sales +
				'}';
	}
}
