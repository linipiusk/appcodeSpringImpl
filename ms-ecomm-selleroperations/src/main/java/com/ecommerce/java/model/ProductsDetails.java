package com.ecommerce.java.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	
	@NotNull @NotBlank @Pattern(regexp = "[a-zA-Z ]*")
	private String productName;
	
	@NotNull @NotBlank @Pattern(regexp = "[0-9]*")
	private String productCount;
	
	@NotNull @NotBlank @Pattern(regexp = "[0-9]*")
	private String productPrice;
	
	@NotNull @NotBlank @Pattern(regexp = "[a-zA-Z ]*")
	private String productCategory;
	
}
