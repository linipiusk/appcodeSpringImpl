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

@Entity(name = "PurchaseHistory")
@Table(name = "buyer_purchase_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@With
public class PurchaseHistory_entity {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "order_id")
	private String orderID;
	
	@Column(name = "transaction_id")
	private String transactionId;
	
	@Column(name = "purchased_prod_id")
	private String purchasedProdID;
	
	@Column(name = "purchased_prod_name")
	private String purchasedProdName;
	
	@Column(name = "purchased_prod_count")
	private String purchasedProdCount;
	
	@Column(name = "purchased_prod_price")
	private String purchasedProdPrice;
	
	@Column(name = "purchased_prod_category")
	private String purchasedProdCategory;
	
	@Column(name = "purchased_time")
	private String purchasedTime;
	
	@Column(name = "buyer_username")
	private String buyerUsername;
	
}
