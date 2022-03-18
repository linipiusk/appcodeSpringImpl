package com.ecommerce.java.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.java.entity.ProductsDetails_entity;
import com.ecommerce.java.mapper.SellerOperationsMapper;
import com.ecommerce.java.model.ProductsDetails;
import com.ecommerce.java.repository.SellerOperationsRepository;

@Service
public class SellerOperationsService {
	
	@Autowired
	SellerOperationsRepository sellerOperationsRepository;
	
	@Autowired
	SellerOperationsMapper sellerOperationsMapper;

	public void handleAddProducts(List<ProductsDetails> prdtDetails, String username) {
		
		List<ProductsDetails_entity> entityList = sellerOperationsMapper.createDBObjectsForAdd(prdtDetails, username);
		sellerOperationsRepository.saveAll(entityList);
	}
	
	@Transactional
	public void handleUpdateProductCount(List<ProductsDetails> prdtDetails, String username) {
		
		List<ProductsDetails_entity> entityList = sellerOperationsMapper.createDBObjectsForUpdateCount(prdtDetails, username);
		entityList.forEach(item -> sellerOperationsRepository.setProductCount(item.getProductId(), item.getProductCount()));
	}
	
	@Transactional
	public void handleUpdateProductPrice(List<ProductsDetails> prdtDetails, String username) {
		
		List<ProductsDetails_entity> entityList = sellerOperationsMapper.createDBObjectsForUpdatePrice(prdtDetails, username);
		entityList.forEach(item -> sellerOperationsRepository.setProductPrice(item.getProductId(), item.getProductPrice()));
	}
}
