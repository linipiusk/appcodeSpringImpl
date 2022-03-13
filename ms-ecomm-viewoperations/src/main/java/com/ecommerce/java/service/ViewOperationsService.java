package com.ecommerce.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.java.entity.ProductsDetails_entity;
import com.ecommerce.java.entity.PurchaseHistory_entity;
import com.ecommerce.java.mapper.ViewOperationsMapper;
import com.ecommerce.java.model.ProductsDetails;
import com.ecommerce.java.model.PurchaseHistory;
import com.ecommerce.java.repository.PurchaseHistoryRepository;
import com.ecommerce.java.repository.ViewOperationsRepository;

@Service
public class ViewOperationsService {

	@Autowired
	ViewOperationsRepository viewOperationsRepository;
	
	@Autowired
	PurchaseHistoryRepository purchaseHistoryRepository;
	
	@Autowired
	ViewOperationsMapper viewOperationsMapper;
	
	public List<ProductsDetails> handleSellerViewAllProductDetails(String username) {
		
		List<ProductsDetails_entity> prdList = viewOperationsRepository.findAllProductsOfSeller(username);
		List<ProductsDetails> productsList = viewOperationsMapper.createResponseToViewAllProducts(prdList);
		return productsList;
	}
	
	public List<ProductsDetails> handleBuyerViewAllProductDetails(String username) {
		
		List<ProductsDetails_entity> prdList = viewOperationsRepository.findAll();
		List<ProductsDetails> productsList = viewOperationsMapper.createResponseToViewAllProducts(prdList);
		return productsList;
	}
	
	public List<ProductsDetails> handleSellerViewProductsBasedOnProductCategory(String username, String category) {
		
		List<ProductsDetails_entity> prdList = viewOperationsRepository.findProductsOfSellerBasedOnCategory(username, category);
		List<ProductsDetails> productsList = viewOperationsMapper.createResponseToViewAllProducts(prdList);
		return productsList;
	}
	
	public List<ProductsDetails> handleBuyerViewProductsBasedOnProductCategory(String category) {
		
		List<ProductsDetails_entity> prdList = viewOperationsRepository.findProductsForBuyerBasedOnCategory(category);
		List<ProductsDetails> productsList = viewOperationsMapper.createResponseToViewAllProducts(prdList);
		return productsList;
	}
	
	public List<PurchaseHistory> handleViewPurchaseHistory(String username) {
		
		List<PurchaseHistory_entity> purchaseListFromDB = purchaseHistoryRepository.findPurchaseHistoryBasedOnUsername(username);
		List<PurchaseHistory> purchaseHistory = viewOperationsMapper.createResponseToViewPurchaseHistory(purchaseListFromDB);
		return purchaseHistory;
	}
}
