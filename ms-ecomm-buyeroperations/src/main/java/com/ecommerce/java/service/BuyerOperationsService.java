package com.ecommerce.java.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.java.entity.ProductsDetails_entity;
import com.ecommerce.java.entity.PurchaseHistory_entity;
import com.ecommerce.java.entity.ShoppingCart_entity;
import com.ecommerce.java.mapper.BuyerOperationsMapper;
import com.ecommerce.java.model.ShoppingCart;
import com.ecommerce.java.model.ShoppingCartView;
import com.ecommerce.java.repository.BuyerOperationsRepository;
import com.ecommerce.java.repository.ProductsRepository;
import com.ecommerce.java.repository.PurchaseHistoryRepository;

@Service
public class BuyerOperationsService {

	@Autowired
	BuyerOperationsMapper buyerOperationsMapper;
	
	@Autowired
	BuyerOperationsRepository buyerOperationsRepository;
	
	@Autowired
	PurchaseHistoryRepository purchaseHistoryRepository;
	
	@Autowired
	ProductsRepository productsRepository;
	
	public void handleAddToCart(List<ShoppingCart> cartDetails, String username) {
		
		List<ShoppingCart_entity> entityList = buyerOperationsMapper.createDBObjectsForAddToCart(cartDetails, username);
		buyerOperationsRepository.saveAll(entityList);
	}

	public ShoppingCartView handleViewCart(String username) {
		
		List<ShoppingCart_entity> cartListFromDB = buyerOperationsRepository.viewCart(username);
		ShoppingCartView shoppingCartView = buyerOperationsMapper.createReponse(cartListFromDB);
		return shoppingCartView;
	}
	
	@Transactional
	public void handleCheckoutCartItems(String username, List<ShoppingCart> cart) {
		
		//Update shopping cart table status
		List<ShoppingCart_entity> entityList = buyerOperationsMapper.updateCheckoutStatusInDB(cart, true);
		entityList.forEach(item -> buyerOperationsRepository.updateCheckoutStatus(item.getCheckoutStatus(), username, item.getSelectedProdID(), item.getOrderId()));
		
		//Add to purchase history table
		List<PurchaseHistory_entity> purchaseList = buyerOperationsMapper.createDBObjectsForPurchaseHistory(cart, username);
		purchaseHistoryRepository.saveAll(purchaseList);
		
		//Update product count in products table
		List<ProductsDetails_entity> productsList = buyerOperationsMapper.createDBObjectsForUpdatingProductsDetails(cart);
		productsList.forEach(item -> productsRepository.updateProductsCount(item.getProductCount(), item.getProductId()));
	}

	@Transactional
	public void handleDiscardCartItems(String username, List<ShoppingCart> cart) {
	
		//Update checkout status in shopping cart table
		List<ShoppingCart_entity> entityList = buyerOperationsMapper.updateCheckoutStatusInDB(cart, false);
		entityList.forEach(item -> buyerOperationsRepository.updateCheckoutStatus(item.getCheckoutStatus(), username, item.getSelectedProdID(), item.getOrderId()));
	}
}
