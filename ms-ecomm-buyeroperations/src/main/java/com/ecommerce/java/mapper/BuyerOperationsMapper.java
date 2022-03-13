package com.ecommerce.java.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ecommerce.java.entity.ProductsDetails_entity;
import com.ecommerce.java.entity.PurchaseHistory_entity;
import com.ecommerce.java.entity.ShoppingCart_entity;
import com.ecommerce.java.model.ShoppingCart;
import com.ecommerce.java.model.ShoppingCartView;

@Component
public class BuyerOperationsMapper {

	public List<ShoppingCart_entity> createDBObjectsForAddToCart(List<ShoppingCart> cartDetails, String username) {

		String transactionId = UUID.randomUUID().toString();
		List<ShoppingCart_entity> entityList = cartDetails.stream().map(rec -> objectToEntityMapperForAddToCart(rec,username,transactionId)).collect(Collectors.toList());
		return entityList;
	}
	
	public ShoppingCart_entity objectToEntityMapperForAddToCart(ShoppingCart details, String username, String transactionId) {
		
		ShoppingCart_entity entity = new ShoppingCart_entity();
		entity.setOrderId(UUID.randomUUID().toString());
		entity.setSelectedProdID(details.getPurchasedProdID());
		entity.setSelectedProdName(details.getPurchasedProdName());
		entity.setSelectedProdCategory(details.getPurchasedProdCategory());
		entity.setSelectedProdCount(details.getPurchasedProdCount());
		entity.setSelectedProdPrice(details.getPurchasedProdPrice());
		entity.setBuyerUsername(username);
		entity.setCheckoutStatus("AddedToCart");
		entity.setTransactionId(transactionId);
		return entity;
	}

	public ShoppingCartView createReponse(List<ShoppingCart_entity> cartListFromDB) {
		
		int totalPrice = cartListFromDB.stream()
				.reduce(0, (total, cart) -> total + (Integer.parseInt(cart.getSelectedProdCount()) * Integer.parseInt(cart.getSelectedProdPrice())), Integer::sum);
		
		List<ShoppingCart> cartDetails = cartListFromDB.stream().map(rec -> entityToObjectMapperForShoppingCartView(rec)).collect(Collectors.toList());
		ShoppingCartView shoppingCartView = new ShoppingCartView();
		shoppingCartView.setShoppingCart(cartDetails);
		shoppingCartView.setTotalAmount(totalPrice);
		return shoppingCartView;
	}
	
	public ShoppingCart entityToObjectMapperForShoppingCartView(ShoppingCart_entity details) {
		
		ShoppingCart cart = new ShoppingCart();
		cart.setCheckoutStatus(details.getCheckoutStatus());
		cart.setPurchasedProdCategory(details.getSelectedProdCategory());
		cart.setPurchasedProdCount(details.getSelectedProdCount());
		cart.setPurchasedProdID(details.getSelectedProdID());
		cart.setPurchasedProdName(details.getSelectedProdName());
		cart.setPurchasedProdPrice(details.getSelectedProdPrice());
		cart.setOrderId(details.getOrderId());
		cart.setTransactionId(details.getTransactionId());
		return cart;
	}
	
	public List<ShoppingCart_entity> updateCheckoutStatusInDB(List<ShoppingCart> cartDetails, Boolean isCheckout) {

		List<ShoppingCart_entity> entityList = cartDetails.stream().map(rec -> objectToEntityMapperForUpdateCheckoutStatus(rec, isCheckout)).collect(Collectors.toList());
		return entityList;
	}
	
	public ShoppingCart_entity objectToEntityMapperForUpdateCheckoutStatus(ShoppingCart details, Boolean isCheckout) {
		
		ShoppingCart_entity entity = new ShoppingCart_entity();
		entity.setOrderId(details.getOrderId());
		entity.setSelectedProdID(details.getPurchasedProdID());
		if (isCheckout)
			entity.setCheckoutStatus("checkoutCart");
		else
			entity.setCheckoutStatus("discardCart");
		return entity;
	}
	
	public List<PurchaseHistory_entity> createDBObjectsForPurchaseHistory(List<ShoppingCart> cartDetails, String username) {

		List<PurchaseHistory_entity> entityList = cartDetails.stream().map(rec -> objectToEntityMapperForPurchaseHistory(rec,username)).collect(Collectors.toList());
		return entityList;
	}
	
	public PurchaseHistory_entity objectToEntityMapperForPurchaseHistory(ShoppingCart details, String username) {
		
		PurchaseHistory_entity entity = new PurchaseHistory_entity();
		entity.setId(UUID.randomUUID().toString());
		entity.setOrderID(details.getOrderId());
		entity.setTransactionId(details.getTransactionId());
		entity.setPurchasedProdID(details.getPurchasedProdID());
		entity.setPurchasedProdName(details.getPurchasedProdName());
		entity.setPurchasedProdCategory(details.getPurchasedProdCategory());
		entity.setPurchasedProdCount(details.getPurchasedProdCount());
		entity.setPurchasedProdPrice(details.getPurchasedProdPrice());
		entity.setBuyerUsername(username);
		entity.setPurchasedTime(LocalDateTime.now().toString());
		return entity;
	}
	
	public List<ProductsDetails_entity> createDBObjectsForUpdatingProductsDetails(List<ShoppingCart> cartDetails) {

		List<ProductsDetails_entity> entityList = cartDetails.stream().map(rec -> objectToEntityMapperForUpdatingProductsDetails(rec)).collect(Collectors.toList());
		return entityList;
	}
	
	public ProductsDetails_entity objectToEntityMapperForUpdatingProductsDetails(ShoppingCart details) {
		
		ProductsDetails_entity entity = new ProductsDetails_entity();
		entity.setProductId(details.getPurchasedProdID());
		entity.setProductCount(details.getPurchasedProdCount());
		return entity;
	}

}
