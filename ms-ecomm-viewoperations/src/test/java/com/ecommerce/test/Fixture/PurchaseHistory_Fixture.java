package com.ecommerce.test.Fixture;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.java.entity.PurchaseHistory_entity;
import com.ecommerce.java.model.PurchaseHistory;

public class PurchaseHistory_Fixture {

	public static List<PurchaseHistory> createPurchaseHistoryListObject() {
		
		PurchaseHistory purchase1 = new PurchaseHistory();
		purchase1.setOrderID("fhfehfg");
		purchase1.setPurchasedProdCategory("Snacks");
		purchase1.setPurchasedProdCount("2");
		purchase1.setPurchasedProdID("jghufgey");
		purchase1.setPurchasedProdName("Lays");
		purchase1.setPurchasedProdPrice("30");
		purchase1.setPurchasedTime(LocalDateTime.now().toString());
		purchase1.setTransactionId("khefurfg");
		
		PurchaseHistory purchase2 = new PurchaseHistory();
		purchase2.setOrderID("rrttfhfehfg");
		purchase2.setPurchasedProdCategory("Snacks");
		purchase2.setPurchasedProdCount("2");
		purchase2.setPurchasedProdID("jgdfrghufgey");
		purchase2.setPurchasedProdName("Pringles");
		purchase2.setPurchasedProdPrice("80");
		purchase2.setPurchasedTime(LocalDateTime.now().toString());
		purchase2.setTransactionId("khefurfg");
		
		List<PurchaseHistory> purchaseList = new ArrayList<>();
		purchaseList.add(purchase1);
		purchaseList.add(purchase2);
		return purchaseList;
	}
	
	public static List<PurchaseHistory_entity> createPurchaseHistoryEntityListObject() {
		
		PurchaseHistory_entity entity1 = new PurchaseHistory_entity();
		entity1.setBuyerUsername("ferf");
		entity1.setId("frgeg");
		entity1.setOrderID("dfegfr");
		entity1.setPurchasedProdCategory("Snacks");
		entity1.setPurchasedProdCount("2");
		entity1.setPurchasedProdID("fgtrg");
		entity1.setPurchasedProdName("Lays");
		entity1.setPurchasedProdPrice("30");
		entity1.setPurchasedTime(LocalDateTime.now().toString());
		entity1.setTransactionId("ferfge");
		
		PurchaseHistory_entity entity2 = new PurchaseHistory_entity();
		entity2.setBuyerUsername("ferf");
		entity2.setId("frgeg445");
		entity2.setOrderID("dfegfr444");
		entity2.setPurchasedProdCategory("Snacks");
		entity2.setPurchasedProdCount("2");
		entity2.setPurchasedProdID("fgtrg43r");
		entity2.setPurchasedProdName("Pringles");
		entity2.setPurchasedProdPrice("90");
		entity2.setPurchasedTime(LocalDateTime.now().toString());
		entity2.setTransactionId("ferfge");
		
		List<PurchaseHistory_entity> entityList = new ArrayList<>();
		entityList.add(entity1);
		entityList.add(entity2);
		return entityList;
	}
}
