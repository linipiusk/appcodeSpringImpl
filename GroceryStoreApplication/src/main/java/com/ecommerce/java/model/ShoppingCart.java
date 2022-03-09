package com.ecommerce.java.model;

public class ShoppingCart {

	private String transactionId;
	private String orderId;
	private String purchasedProdID;
	private String purchasedProdName;
	private String purchasedProdCount;
	private String purchasedProdPrice;
	private String purchasedProdCategory;
	private String purchasedTime;
	private String buyerUsername;
	private String checkoutStatus;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public String getBuyerUsername() {
		return buyerUsername;
	}
	public void setBuyerUsername(String buyerUsername) {
		this.buyerUsername = buyerUsername;
	}
	public String getCheckoutStatus() {
		return checkoutStatus;
	}
	public void setCheckoutStatus(String checkoutStatus) {
		this.checkoutStatus = checkoutStatus;
	}
	@Override
	public String toString() {
		return "ShoppingCart [transactionId=" + transactionId + ", orderId=" + orderId + ", purchasedProdID="
				+ purchasedProdID + ", purchasedProdName=" + purchasedProdName + ", purchasedProdCount="
				+ purchasedProdCount + ", purchasedProdPrice=" + purchasedProdPrice + ", purchasedProdCategory="
				+ purchasedProdCategory + ", purchasedTime=" + purchasedTime + "]";
	}
}
