package com.ecommerce.java.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductsDetails {

	private String productId;
	
	private String productName;
	
	private String productCount;
	
	private String productPrice;
	
	private String productCategory;
	
}
