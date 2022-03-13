package com.ecommerce.test.fixture;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.java.entity.PurchaseHistory_entity;

public class PurchaseHistory_Fixture {

	public static List<PurchaseHistory_entity> createPurchaseHistoryListObject() {
		
		PurchaseHistory_entity purchase1 = new PurchaseHistory_entity();
		purchase1.setBuyerUsername("ferf");
		purchase1.setOrderID("fhfehfg");
		purchase1.setPurchasedProdCategory("Snacks");
		purchase1.setPurchasedProdCount("2");
		purchase1.setPurchasedProdID("jghufgey");
		purchase1.setPurchasedProdName("Lays");
		purchase1.setPurchasedProdPrice("30");
		purchase1.setPurchasedTime(LocalDateTime.now().toString());
		purchase1.setTransactionId("khefurfg");
		
		PurchaseHistory_entity purchase2 = new PurchaseHistory_entity();
		purchase2.setBuyerUsername("ferf");
		purchase2.setOrderID("rrttfhfehfg");
		purchase2.setPurchasedProdCategory("Snacks");
		purchase2.setPurchasedProdCount("2");
		purchase2.setPurchasedProdID("jgdfrghufgey");
		purchase2.setPurchasedProdName("Pringles");
		purchase2.setPurchasedProdPrice("80");
		purchase2.setPurchasedTime(LocalDateTime.now().toString());
		purchase2.setTransactionId("khefurfg");
		
		List<PurchaseHistory_entity> purchaseList = new ArrayList<>();
		purchaseList.add(purchase1);
		purchaseList.add(purchase2);
		return purchaseList;
	}
}
