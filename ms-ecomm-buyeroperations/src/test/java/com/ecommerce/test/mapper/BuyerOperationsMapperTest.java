package com.ecommerce.test.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ecommerce.java.entity.ShoppingCart_entity;
import com.ecommerce.java.mapper.BuyerOperationsMapper;
import com.ecommerce.java.model.ShoppingCart;
import com.ecommerce.test.fixture.ShoppingCartFixture;

@RunWith(MockitoJUnitRunner.class)
public class BuyerOperationsMapperTest {

	@InjectMocks
	BuyerOperationsMapper buyerOperationsMapper;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createDBObjectsForAddToCart_test() {
		
		List<ShoppingCart> cartDetails = ShoppingCartFixture.createShoppingCartListObject();
		assertNotNull(buyerOperationsMapper.createDBObjectsForAddToCart(cartDetails, "jhwef"));
	}
	
	@Test
	public void createResponse_test() {
		
		List<ShoppingCart_entity> cartListFromDB = ShoppingCartFixture.createShoppingCartListEntityObject();
		assertNotNull(buyerOperationsMapper.createReponse(cartListFromDB));
	}
	
	@Test
	public void updateCheckoutStatusInDB_checkoutCart_test() {
		
		List<ShoppingCart> cartDetails = ShoppingCartFixture.createShoppingCartListToCheckout();
		assertNotNull(buyerOperationsMapper.updateCheckoutStatusInDB(cartDetails, true));
	}
	
	@Test
	public void updateCheckoutStatusInDB_DisregardCart_test() {
		
		List<ShoppingCart> cartDetails = ShoppingCartFixture.createShoppingCartListToCheckout();
		assertNotNull(buyerOperationsMapper.updateCheckoutStatusInDB(cartDetails, false));
	}
	
	@Test
	public void createDBObjectsForPurchaseHistory_test() {
		
		List<ShoppingCart> cartDetails = ShoppingCartFixture.createShoppingCartListObject();
		assertNotNull(buyerOperationsMapper.createDBObjectsForPurchaseHistory(cartDetails, "fder"));
	}
	
	@Test
	public void createDBObjectsForUpdatingProductsDetails_test() {
		
		List<ShoppingCart> cartDetails = ShoppingCartFixture.createShoppingCartListObject();
		assertNotNull(buyerOperationsMapper.createDBObjectsForUpdatingProductsDetails(cartDetails));
	}
}
