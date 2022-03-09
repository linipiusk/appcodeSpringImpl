package com.ecommerce.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.java.model.ProductsDetails;
import com.ecommerce.java.model.PurchaseHistory;
import com.ecommerce.java.service.ViewOperationsService;

@RestController
@RequestMapping("/grocerystore")
public class ViewOperationsController {

	@Autowired
	ViewOperationsService viewOperationsService;
	
	@GetMapping("/viewallproducts/{username}")
	public ResponseEntity<List<ProductsDetails>> viewallproducts(@PathVariable String username, @RequestParam String userrole){
		
		List<ProductsDetails> prodList = viewOperationsService.handleViewAllProductDetails(username, userrole);
		return ResponseEntity.ok(prodList);
	}
	
	@GetMapping("/viewproducts/{username}")
	public ResponseEntity<List<ProductsDetails>> viewproducts(@PathVariable String username, @RequestParam String userrole, @RequestParam String category){
		
		List<ProductsDetails> prodList = viewOperationsService.handleViewProductsBasedOnProductCategory(username, userrole, category);
		return ResponseEntity.ok(prodList);
	}
	
	@GetMapping("/viewpurchasehistory/{username}")
	public ResponseEntity<List<PurchaseHistory>> viewpurchasehistory(@PathVariable String username, @RequestParam String userrole){
		
		List<PurchaseHistory> prodList = viewOperationsService.handleViewPurchaseHistory(username, userrole);
		return ResponseEntity.ok(prodList);
	}
}
