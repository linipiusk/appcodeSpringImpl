package com.ecommerce.test.fixture;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.java.entity.ProductsDetails_entity;

public class ProductsDetails_Fixture {
	
	public static List<ProductsDetails_entity> createProductsDetailsListDBObject() {
		
		ProductsDetails_entity prd1 = new ProductsDetails_entity();
		prd1.setProductCategory("Snacks");		
		prd1.setProductCount("34");
		prd1.setProductId("fer4455");
		prd1.setProductName("Pringles");
		prd1.setProductPrice("80");
		
		ProductsDetails_entity prd2 = new ProductsDetails_entity();
		prd2.setProductCategory("Snacks");		
		prd2.setProductCount("45");
		prd2.setProductId("fdfb65");
		prd2.setProductName("Bingo");
		prd2.setProductPrice("30");
		
		List<ProductsDetails_entity> prdList = new ArrayList<>();
		prdList.add(prd1);
		prdList.add(prd2);
		
		return prdList;	
	}
	
}
