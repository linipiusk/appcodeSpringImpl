package com.ecommerce.java.model;

public class ProductsDetails {

	private String productId;
	private String productName;
	private String productCount;
	private String productPrice;
	private String productCategory;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCount() {
		return productCount;
	}
	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	@Override
	public String toString() {
		return "ProductID: " + productId + ", ProductName: " + productName + ", ProductCount: "
				+ productCount + ", ProductPrice: " + productPrice + ", ProductCategory: " + productCategory;
	}
}
