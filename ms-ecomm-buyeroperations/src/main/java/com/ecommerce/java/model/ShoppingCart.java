package com.ecommerce.java.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class ShoppingCart {
	
	private String orderId;
	
	private String transactionId;
	
	@NotNull @NotBlank
	private String purchasedProdID;
	
	@NotNull @NotBlank
	private String purchasedProdName;
	
	@NotNull @NotBlank
	private String purchasedProdCount;
	
	@NotNull @NotBlank
	private String purchasedProdPrice;
	
	@NotNull @NotBlank
	private String purchasedProdCategory;
	
	private String checkoutStatus;
}
