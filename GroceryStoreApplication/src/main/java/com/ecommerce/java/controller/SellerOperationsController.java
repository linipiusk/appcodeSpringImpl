package com.ecommerce.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.java.model.ProductsDetails;
import com.ecommerce.java.service.SellerOperationsService;

@RestController
@RequestMapping("/grocerystore")
public class SellerOperationsController {

	@Autowired
	SellerOperationsService sellerOperationsService;
	
	@PostMapping("/addproducts/{username}")
	public ResponseEntity<String> addproducts(@PathVariable String username, @RequestBody List<ProductsDetails> details){
		
		sellerOperationsService.handleAddProducts(details);
		return ResponseEntity.ok("Successful");
	}
	
	@PatchMapping("/modifycost/{username}")
	public ResponseEntity<String> modifycost(@PathVariable String username, @RequestBody List<ProductsDetails> details){
		
		sellerOperationsService.handleUpdateProductPrice(details);
		return ResponseEntity.ok("Successful");
	}
	
	@PatchMapping("/modifycount/{username}")
	public ResponseEntity<String> modifycount(@PathVariable String username, @RequestBody List<ProductsDetails> details){
		
		sellerOperationsService.handleUpdateProductCount(details);
		return ResponseEntity.ok("Successful");
	}
}
