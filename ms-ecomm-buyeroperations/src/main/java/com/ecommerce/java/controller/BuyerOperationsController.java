package com.ecommerce.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.java.exception.CustomException;
import com.ecommerce.java.model.ShoppingCart;
import com.ecommerce.java.model.ShoppingCartView;
import com.ecommerce.java.service.BuyerOperationsService;

@RestController
@RequestMapping("/grocerystore")
public class BuyerOperationsController {

	@Autowired
	BuyerOperationsService buyerOperationsService;
	
	@PostMapping("/buyercheckout/{username}")
	public ResponseEntity<String> addproducts(@PathVariable String username, @RequestBody List<ShoppingCart> cart){
		
		buyerOperationsService.handleAddToCart(cart, username);
		return ResponseEntity.ok("Successful");
	}
	
	@GetMapping("/viewshoppingcart/{username}")
	public ResponseEntity<ShoppingCartView> viewshoppingcart(@PathVariable String username){
		
		ShoppingCartView cart = buyerOperationsService.handleViewCart(username);
		return ResponseEntity.ok(cart);
	}
	
	@PostMapping("/confirmcheckout/{username}")
	public ResponseEntity<String> confirmcheckout(@PathVariable String username, @RequestParam String checkoutstatus, @RequestBody List<ShoppingCart> cart) throws CustomException{
		
		if(checkoutstatus.equalsIgnoreCase("SUCCESS")) {
			buyerOperationsService.handleCheckoutCartItems(username, cart);
			
		} else if (checkoutstatus.equalsIgnoreCase("FAILED")) {
			buyerOperationsService.handleDiscardCartItems(username, cart);
			
		} else {
			throw new CustomException("Invalid input - checkoutstatus");
		}
		return ResponseEntity.ok("Successful");
	}
}
