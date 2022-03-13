package com.ecommerce.java.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ecommerce.java.entity.ProductsDetails_entity;
import com.ecommerce.java.entity.PurchaseHistory_entity;
import com.ecommerce.java.model.ProductsDetails;
import com.ecommerce.java.model.PurchaseHistory;

@Component
public class ViewOperationsMapper {

	public List<ProductsDetails> createResponseToViewAllProducts(List<ProductsDetails_entity> prdList) {
		
		List<ProductsDetails> productsList = prdList.stream().map(rec -> entityToObjectMapperToViewAllProducts(rec)).collect(Collectors.toList());
		return productsList;
	}
	
	public ProductsDetails entityToObjectMapperToViewAllProducts(ProductsDetails_entity prdFromDB) {

		ProductsDetails details = new ProductsDetails();
		details.setProductCategory(prdFromDB.getProductCategory());
		details.setProductCount(prdFromDB.getProductCount());
		details.setProductId(prdFromDB.getProductId());
		details.setProductName(prdFromDB.getProductName());
		details.setProductPrice(prdFromDB.getProductPrice());
		return details;
	}
	
	public List<PurchaseHistory> createResponseToViewPurchaseHistory(List<PurchaseHistory_entity> prdList) {
		
		List<PurchaseHistory> productsList = prdList.stream().map(rec -> entityToObjectMapperToViewPurchaseHistory(rec)).collect(Collectors.toList());
		return productsList;
	}
	
	public PurchaseHistory entityToObjectMapperToViewPurchaseHistory(PurchaseHistory_entity prdFromDB) {

		PurchaseHistory details = new PurchaseHistory();
		details.setOrderID(prdFromDB.getOrderID());
		details.setPurchasedProdCategory(prdFromDB.getPurchasedProdCategory());
		details.setPurchasedProdCount(prdFromDB.getPurchasedProdCount());
		details.setPurchasedProdID(prdFromDB.getPurchasedProdID());
		details.setPurchasedProdName(prdFromDB.getPurchasedProdName());
		details.setPurchasedProdPrice(prdFromDB.getPurchasedProdPrice());
		details.setPurchasedTime(prdFromDB.getPurchasedTime());
		details.setTransactionId(prdFromDB.getTransactionId());
		return details;
	}

}
