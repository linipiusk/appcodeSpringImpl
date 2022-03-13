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
public class PurchaseHistory {

	private String orderID;
	
	private String purchasedProdID;
	
	private String purchasedProdName;
	
	private String purchasedProdCount;
	
	private String purchasedProdPrice;
	
	private String purchasedProdCategory;
	
	private String purchasedTime;
	
	private String transactionId;

}
