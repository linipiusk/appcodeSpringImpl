package com.ecommerce.test.service;

import static org.mockito.Mockito.lenient;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ecommerce.java.entity.ProductsDetails_entity;
import com.ecommerce.java.entity.PurchaseHistory_entity;
import com.ecommerce.java.entity.ShoppingCart_entity;
import com.ecommerce.java.mapper.BuyerOperationsMapper;
import com.ecommerce.java.model.ShoppingCart;
import com.ecommerce.java.repository.BuyerOperationsRepository;
import com.ecommerce.java.repository.ProductsRepository;
import com.ecommerce.java.repository.PurchaseHistoryRepository;
import com.ecommerce.java.service.BuyerOperationsService;
import com.ecommerce.test.fixture.ProductsDetails_Fixture;
import com.ecommerce.test.fixture.PurchaseHistory_Fixture;
import com.ecommerce.test.fixture.ShoppingCartFixture;

@RunWith(MockitoJUnitRunner.class)
public class BuyerOperationsServiceTest {

	@Mock
	BuyerOperationsMapper buyerOperationsMapper;
	
	@Mock
	BuyerOperationsRepository buyerOperationsRepository;
	
	@Mock
	PurchaseHistoryRepository purchaseHistoryRepository;
	
	@Mock
	ProductsRepository productsRepository;
	
	@InjectMocks
	BuyerOperationsService buyerOperationsService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void handleAddToCart_test() {
		
		List<ShoppingCart> cartDetails = ShoppingCartFixture.createShoppingCartListObject();
		List<ShoppingCart_entity> entityList = ShoppingCartFixture.createShoppingCartListEntityObject();
		lenient().when(buyerOperationsMapper.createDBObjectsForAddToCart(Mockito.anyList(),Mockito.anyString())).thenReturn(entityList);
		buyerOperationsService.handleAddToCart(cartDetails, "ferf");
	}
	
	@Test
	public void handleCheckoutCartItems_test() {
		
		List<ShoppingCart_entity> entityList = ShoppingCartFixture.createShoppingCartListEntityObject();
		lenient().when(buyerOperationsMapper.updateCheckoutStatusInDB(Mockito.anyList(),Mockito.anyBoolean())).thenReturn(entityList);
		
		List<PurchaseHistory_entity> purchaseList = PurchaseHistory_Fixture.createPurchaseHistoryListObject();
		lenient().when(buyerOperationsMapper.createDBObjectsForPurchaseHistory(Mockito.anyList(),Mockito.anyString())).thenReturn(purchaseList);
		
		List<ProductsDetails_entity> productsList = ProductsDetails_Fixture.createProductsDetailsListDBObject();
		lenient().when(buyerOperationsMapper.createDBObjectsForUpdatingProductsDetails(Mockito.anyList())).thenReturn(productsList);
		List<ShoppingCart> cartDetails = ShoppingCartFixture.createShoppingCartListObject();
		buyerOperationsService.handleCheckoutCartItems("ferf", cartDetails);
	}
	
	@Test
	public void handleDiscardCartItems_test() {
		
		List<ShoppingCart_entity> entityList = ShoppingCartFixture.createShoppingCartListEntityObject();
		lenient().when(buyerOperationsMapper.updateCheckoutStatusInDB(Mockito.anyList(),Mockito.anyBoolean())).thenReturn(entityList);
		
		List<ShoppingCart> cartDetails = ShoppingCartFixture.createShoppingCartListObject();
		buyerOperationsService.handleDiscardCartItems("dfe", cartDetails);
	}
}
