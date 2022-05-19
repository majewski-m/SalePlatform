package com.example.SalePlatform.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int quantitySold;

	private LocalDateTime saleTime;

	@ManyToOne
	@JoinColumn(name = "buyer_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Sale() {
	}

	public Sale(int quantitySold, LocalDateTime saleTime, User user, Product product) {
		this.quantitySold = quantitySold;
		this.saleTime = saleTime;
		this.user = user;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}

	public LocalDateTime getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(LocalDateTime saleTime) {
		this.saleTime = saleTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Sale{" +
				"id=" + id +
				", quantitySold=" + quantitySold +
				", saleTime=" + saleTime +
				", user=" + user +
				", product=" + product +
				'}';
	}
}
