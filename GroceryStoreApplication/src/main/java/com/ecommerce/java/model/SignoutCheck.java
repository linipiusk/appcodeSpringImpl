package com.ecommerce.java.model;

import java.util.List;

public class SignoutCheck {

	
	private String message;
	private List<ProductsDetails> productDetails;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ProductsDetails> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<ProductsDetails> productDetails) {
		this.productDetails = productDetails;
	}
	
	
}
