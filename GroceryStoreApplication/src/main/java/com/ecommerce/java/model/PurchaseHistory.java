package com.ecommerce.java.model;

public class PurchaseHistory {

	private String orderID;
	private String purchasedProdID;
	private String purchasedProdName;
	private String purchasedProdCount;
	private String purchasedProdPrice;
	private String purchasedProdCategory;
	private String purchasedTime;
	private String transactionId;
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getPurchasedProdID() {
		return purchasedProdID;
	}
	public void setPurchasedProdID(String purchasedProdID) {
		this.purchasedProdID = purchasedProdID;
	}
	public String getPurchasedProdName() {
		return purchasedProdName;
	}
	public void setPurchasedProdName(String purchasedProdName) {
		this.purchasedProdName = purchasedProdName;
	}
	public String getPurchasedProdCount() {
		return purchasedProdCount;
	}
	public void setPurchasedProdCount(String purchasedProdCount) {
		this.purchasedProdCount = purchasedProdCount;
	}
	public String getPurchasedProdPrice() {
		return purchasedProdPrice;
	}
	public void setPurchasedProdPrice(String purchasedProdPrice) {
		this.purchasedProdPrice = purchasedProdPrice;
	}
	public String getPurchasedProdCategory() {
		return purchasedProdCategory;
	}
	public void setPurchasedProdCategory(String purchasedProdCategory) {
		this.purchasedProdCategory = purchasedProdCategory;
	}
	public String getPurchasedTime() {
		return purchasedTime;
	}
	public void setPurchasedTime(String purchasedTime) {
		this.purchasedTime = purchasedTime;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "PurchaseHistory [orderID=" + orderID + ", purchasedProdID=" + purchasedProdID + ", purchasedProdName="
				+ purchasedProdName + ", purchasedProdCount=" + purchasedProdCount + ", purchasedProdPrice="
				+ purchasedProdPrice + ", purchasedProdCategory=" + purchasedProdCategory + ", purchasedTime="
				+ purchasedTime + ", transactionId=" + transactionId + "]";
	}
	
	
}
