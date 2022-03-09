package com.ecommerce.java.entity;

public class ProductsDetails_entity {

	private String productId;
	private String productName;
	private String productCount;
	private String productPrice;
	private String productCategory;
	private String sellerUsername;
	
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
	public String getSellerUsername() {
		return sellerUsername;
	}
	public void setSellerUsername(String sellerUsername) {
		this.sellerUsername = sellerUsername;
	}
	@Override
	public String toString() {
		return "ProductID: " + productId + ", ProductName: " + productName + ", ProductCount: "
				+ productCount + ", ProductPrice: " + productPrice + ", ProductCategory: " + productCategory;
	}
}
