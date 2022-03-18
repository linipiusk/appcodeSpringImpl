package com.ecommerce.java.mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ecommerce.java.entity.ProductsDetails_entity;
import com.ecommerce.java.model.ProductsDetails;

@Component
public class SellerOperationsMapper {

	public List<ProductsDetails_entity> createDBObjectsForAdd(List<ProductsDetails> prdtDetails, String username) {

		List<ProductsDetails_entity> entityList = prdtDetails.stream().map(rec -> objectToEntityMapperForAdd(rec,username)).collect(Collectors.toList());
		return entityList;
	}
	
	public ProductsDetails_entity objectToEntityMapperForAdd(ProductsDetails details, String username) {
		
		ProductsDetails_entity entity = new ProductsDetails_entity();
		entity.setProductId(UUID.randomUUID().toString());
		entity.setProductName(details.getProductName());
		entity.setProductCategory(details.getProductCategory());
		entity.setProductCount(details.getProductCount());
		entity.setProductPrice(details.getProductPrice());
		entity.setSellerUsername(username);
		return entity;
	}
	
	public List<ProductsDetails_entity> createDBObjectsForUpdateCount(List<ProductsDetails> prdtDetails, String username) {

		List<ProductsDetails_entity> entityList = prdtDetails.stream().map(rec -> objectToEntityMapperForUpdateCount(rec,username)).collect(Collectors.toList());
		return entityList;
	}
	
	public ProductsDetails_entity objectToEntityMapperForUpdateCount(ProductsDetails details, String username) {
		
		ProductsDetails_entity entity = new ProductsDetails_entity();
		entity.setProductId(details.getProductId());
		entity.setProductCount(details.getProductCount());
		entity.setSellerUsername(username);
		return entity;
	}
	
	public List<ProductsDetails_entity> createDBObjectsForUpdatePrice(List<ProductsDetails> prdtDetails, String username) {

		List<ProductsDetails_entity> entityList = prdtDetails.stream().map(rec -> objectToEntityMapperForUpdatePrice(rec,username)).collect(Collectors.toList());
		return entityList;
	}
	
	public ProductsDetails_entity objectToEntityMapperForUpdatePrice(ProductsDetails details, String username) {
		
		ProductsDetails_entity entity = new ProductsDetails_entity();
		entity.setProductId(details.getProductId());
		entity.setProductPrice(details.getProductPrice());
		entity.setSellerUsername(username);
		return entity;
	}

}
