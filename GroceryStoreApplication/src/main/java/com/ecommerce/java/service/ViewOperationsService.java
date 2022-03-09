package com.ecommerce.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.java.model.ProductsDetails;
import com.ecommerce.java.model.PurchaseHistory;

@Service
public class ViewOperationsService {

	
	
	public List<ProductsDetails> handleViewAllProductDetails(String username, String userrole) {
		
		
		return null;
	}
	
	public List<ProductsDetails> handleViewProductsBasedOnProductCategory(String username, String userrole, String category) {
		
		return null;
	}
	
	public List<PurchaseHistory> handleViewPurchaseHistory(String username, String userrole) {
		
		return null;
	}
}
