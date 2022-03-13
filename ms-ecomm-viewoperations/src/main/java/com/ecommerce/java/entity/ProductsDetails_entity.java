package com.ecommerce.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;

@Entity(name = "ProductsDetails")
@Table(name = "products_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@With
public class ProductsDetails_entity {

	@Id
	@Column(name = "product_id")
	private String productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_count")
	private String productCount;
	
	@Column(name = "product_price")
	private String productPrice;
	
	@Column(name = "product_category")
	private String productCategory;
	
	@Column(name = "seller_username")
	private String sellerUsername;
}
