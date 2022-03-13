package com.ecommerce.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.java.exception.CustomException;
import com.ecommerce.java.model.ProductsDetails;
import com.ecommerce.java.model.PurchaseHistory;
import com.ecommerce.java.service.ViewOperationsService;

@RestController
@RequestMapping("/grocerystore")
public class ViewOperationsController {

	@Autowired
	ViewOperationsService viewOperationsService;
	
	@GetMapping("/viewallproducts/{username}")
	public ResponseEntity<List<ProductsDetails>> viewallproducts(@PathVariable String username, @RequestParam String userrole) throws CustomException{
		
		List<ProductsDetails> prodList = null;
		
		if (userrole.equalsIgnoreCase("seller"))
			prodList = viewOperationsService.handleSellerViewAllProductDetails(username);
		
		else if (userrole.equalsIgnoreCase("buyer"))
			prodList = viewOperationsService.handleBuyerViewAllProductDetails(username);
		
		else
			throw new CustomException("Invalid input - userrole");
		
		if(prodList.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok(prodList);
	}
	
	@GetMapping("/viewproducts/{username}")
	public ResponseEntity<List<ProductsDetails>> viewproducts(@PathVariable String username, @RequestParam String userrole, @RequestParam String category) throws CustomException{
		
		List<ProductsDetails> prodList = null;
		
		if (userrole.equalsIgnoreCase("seller"))
			prodList = viewOperationsService.handleSellerViewProductsBasedOnProductCategory(username, category);
		
		else if (userrole.equalsIgnoreCase("buyer"))
			prodList = viewOperationsService.handleBuyerViewProductsBasedOnProductCategory(category);
		
		else
			throw new CustomException("Invalid input - userrole");
		
		if(prodList.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return ResponseEntity.ok(prodList);
	}
	
	@GetMapping("/viewpurchasehistory/{username}")
	public ResponseEntity<List<PurchaseHistory>> viewpurchasehistory(@PathVariable String username){
		
		List<PurchaseHistory> purchaseList = viewOperationsService.handleViewPurchaseHistory(username);
		
		if(purchaseList.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return ResponseEntity.ok(purchaseList);
	}
}
