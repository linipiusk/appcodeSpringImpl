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

@Entity(name = "ShoppingCart")
@Table(name = "shopping_cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@With
public class ShoppingCart_entity {

	@Id
	@Column(name = "order_id")
	private String orderId;
	
	@Column(name = "transaction_id")
	private String transactionId;
	
	@Column(name = "selected_prod_id")
	private String selectedProdID;
	
	@Column(name = "selected_prod_name")
	private String selectedProdName;
	
	@Column(name = "selected_prod_count")
	private String selectedProdCount;
	
	@Column(name = "selected_prod_price")
	private String selectedProdPrice;
	
	@Column(name = "selected_prod_category")
	private String selectedProdCategory;
	
	@Column(name = "buyer_username")
	private String buyerUsername;
	
	@Column(name = "checkout_status")
	private String checkoutStatus;
	
}
