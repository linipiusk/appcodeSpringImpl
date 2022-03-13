package com.ecommerce.test.fixture;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.java.entity.ShoppingCart_entity;
import com.ecommerce.java.model.ShoppingCart;
import com.ecommerce.java.model.ShoppingCartView;

public class ShoppingCartFixture {

	public static List<ShoppingCart> createShoppingCartListObject() {
		
		ShoppingCart cart1 = new ShoppingCart();
		cart1.setPurchasedProdCategory("Snacks");
		cart1.setPurchasedProdCount("2");
		cart1.setPurchasedProdID("fehgfueryg");
		cart1.setPurchasedProdName("Bingo chips");
		cart1.setPurchasedProdPrice("40");
		
		ShoppingCart cart2 = new ShoppingCart();
		cart2.setPurchasedProdCategory("Snacks");
		cart2.setPurchasedProdCount("4");
		cart2.setPurchasedProdID("fnjjkfueryg");
		cart2.setPurchasedProdName("Lays chips");
		cart2.setPurchasedProdPrice("30");
		
		List<ShoppingCart> cartList = new ArrayList<>();
		cartList.add(cart1);
		cartList.add(cart2);
		
		return cartList;
	}
	
	public static ShoppingCartView createShoppingCartListObjectToView() {
		
		ShoppingCart cart1 = new ShoppingCart();
		cart1.setPurchasedProdCategory("Snacks");
		cart1.setPurchasedProdCount("2");
		cart1.setPurchasedProdID("fehgfueryg");
		cart1.setPurchasedProdName("Bingo chips");
		cart1.setPurchasedProdPrice("40");
		cart1.setCheckoutStatus("AddedToCart");
		cart1.setOrderId("kjhgdfd");
		cart1.setTransactionId("jhhfdx");
		
		ShoppingCart cart2 = new ShoppingCart();
		cart2.setPurchasedProdCategory("Snacks");
		cart2.setPurchasedProdCount("4");
		cart2.setPurchasedProdID("fnjjkfueryg");
		cart2.setPurchasedProdName("Lays chips");
		cart2.setPurchasedProdPrice("30");
		cart1.setCheckoutStatus("AddedToCart");
		cart1.setOrderId("liudybd");
		cart1.setTransactionId("jhhfdx");
		
		List<ShoppingCart> cartList = new ArrayList<>();
		cartList.add(cart1);
		cartList.add(cart2);
		
		ShoppingCartView cartView = new ShoppingCartView();
		cartView.setShoppingCart(cartList);
		cartView.setTotalAmount(200);
		
		return cartView;
	}
	
	public static List<ShoppingCart> createShoppingCartListToCheckout() {
		
		ShoppingCart cart1 = new ShoppingCart();
		cart1.setPurchasedProdCategory("Snacks");
		cart1.setPurchasedProdCount("2");
		cart1.setPurchasedProdID("fehgfueryg");
		cart1.setPurchasedProdName("Bingo chips");
		cart1.setPurchasedProdPrice("40");
		cart1.setCheckoutStatus("AddedToCart");
		cart1.setOrderId("kjhgdfd");
		cart1.setTransactionId("jhhfdx");
		
		ShoppingCart cart2 = new ShoppingCart();
		cart2.setPurchasedProdCategory("Snacks");
		cart2.setPurchasedProdCount("4");
		cart2.setPurchasedProdID("fnjjkfueryg");
		cart2.setPurchasedProdName("Lays chips");
		cart2.setPurchasedProdPrice("30");
		cart1.setCheckoutStatus("AddedToCart");
		cart1.setOrderId("liudybd");
		cart1.setTransactionId("jhhfdx");
		
		List<ShoppingCart> cartList = new ArrayList<>();
		cartList.add(cart1);
		cartList.add(cart2);
		
		return cartList;
	}
	
	public static List<ShoppingCart_entity> createShoppingCartListEntityObject() {
		
		ShoppingCart_entity entity1 = new ShoppingCart_entity();
		entity1.setBuyerUsername("ferf");
		entity1.setCheckoutStatus("AddedToCart");
		entity1.setOrderId("vfffrrt");
		entity1.setSelectedProdCategory("Snacks");
		entity1.setSelectedProdCount("3");
		entity1.setSelectedProdID("fergtrg");
		entity1.setSelectedProdName("Lays");
		entity1.setSelectedProdPrice("45");
		entity1.setTransactionId("fregregt");
		
		ShoppingCart_entity entity2 = new ShoppingCart_entity();
		entity2.setBuyerUsername("ferf");
		entity2.setCheckoutStatus("AddedToCart");
		entity2.setOrderId("vfffrtyuurt");
		entity2.setSelectedProdCategory("Snacks");
		entity2.setSelectedProdCount("3");
		entity2.setSelectedProdID("ferweeegtrg");
		entity2.setSelectedProdName("Bingo");
		entity2.setSelectedProdPrice("35");
		entity2.setTransactionId("fregregt");
		
		List<ShoppingCart_entity> entityList = new ArrayList<>();
		entityList.add(entity1);
		entityList.add(entity2);
		return entityList;
	}
}
