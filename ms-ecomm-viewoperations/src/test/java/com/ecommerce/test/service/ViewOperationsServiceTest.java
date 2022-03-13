package com.ecommerce.test.service;

import static org.junit.Assert.assertNotNull;
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
import com.ecommerce.java.mapper.ViewOperationsMapper;
import com.ecommerce.java.model.ProductsDetails;
import com.ecommerce.java.model.PurchaseHistory;
import com.ecommerce.java.repository.PurchaseHistoryRepository;
import com.ecommerce.java.repository.ViewOperationsRepository;
import com.ecommerce.java.service.ViewOperationsService;
import com.ecommerce.test.Fixture.ProductsDetails_Fixture;
import com.ecommerce.test.Fixture.PurchaseHistory_Fixture;

@RunWith(MockitoJUnitRunner.class)
public class ViewOperationsServiceTest {

	@Mock
	ViewOperationsRepository viewOperationsRepository;
	
	@Mock
	PurchaseHistoryRepository purchaseHistoryRepository;
	
	@Mock
	ViewOperationsMapper viewOperationsMapper;
	
	@InjectMocks
	ViewOperationsService viewOperationsService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void handleSellerViewAllProductDetails_test() {
		
		List<ProductsDetails_entity> prdList = ProductsDetails_Fixture.createProductsDetailsListDBObject();
		lenient().when(viewOperationsRepository.findAllProductsOfSeller(Mockito.anyString())).thenReturn(prdList);
		
		List<ProductsDetails> productsList = ProductsDetails_Fixture.createProductsDetailsListObject();
		lenient().when(viewOperationsMapper.createResponseToViewAllProducts(Mockito.anyList())).thenReturn(productsList);
		
		assertNotNull(viewOperationsService.handleSellerViewAllProductDetails("ferf"));
	}
	
	@Test
	public void handleBuyerViewAllProductDetails_test() {
		
		List<ProductsDetails_entity> prdList = ProductsDetails_Fixture.createProductsDetailsListDBObject();
		lenient().when(viewOperationsRepository.findAllProductsOfSeller(Mockito.anyString())).thenReturn(prdList);
		
		List<ProductsDetails> productsList = ProductsDetails_Fixture.createProductsDetailsListObject();
		lenient().when(viewOperationsMapper.createResponseToViewAllProducts(Mockito.anyList())).thenReturn(productsList);
		
		assertNotNull(viewOperationsService.handleBuyerViewAllProductDetails("ferf"));
	}
	
	@Test
	public void handleSellerViewProductDetailsByCategory_test() {
		
		List<ProductsDetails_entity> prdList = ProductsDetails_Fixture.createProductsDetailsListDBObject();
		lenient().when(viewOperationsRepository.findProductsOfSellerBasedOnCategory(Mockito.anyString(), Mockito.anyString())).thenReturn(prdList);
		
		List<ProductsDetails> productsList = ProductsDetails_Fixture.createProductsDetailsListObject();
		lenient().when(viewOperationsMapper.createResponseToViewAllProducts(Mockito.anyList())).thenReturn(productsList);
		
		assertNotNull(viewOperationsService.handleSellerViewProductsBasedOnProductCategory("ferf", "Snacks"));
	}
	
	@Test
	public void handleBuyerViewProductDetailsByCategory_test() {
		
		List<ProductsDetails_entity> prdList = ProductsDetails_Fixture.createProductsDetailsListDBObject();
		lenient().when(viewOperationsRepository.findProductsForBuyerBasedOnCategory(Mockito.anyString())).thenReturn(prdList);
		
		List<ProductsDetails> productsList = ProductsDetails_Fixture.createProductsDetailsListObject();
		lenient().when(viewOperationsMapper.createResponseToViewAllProducts(Mockito.anyList())).thenReturn(productsList);
		
		assertNotNull(viewOperationsService.handleBuyerViewProductsBasedOnProductCategory("ferf"));
	}
	
	@Test
	public void handleViewPurchaseHistory_test() {
		
		List<PurchaseHistory_entity> purchaseListFromDB = PurchaseHistory_Fixture.createPurchaseHistoryEntityListObject();
		lenient().when(purchaseHistoryRepository.findPurchaseHistoryBasedOnUsername("ferf")).thenReturn(purchaseListFromDB);
		
		List<PurchaseHistory> purchaseHistory = PurchaseHistory_Fixture.createPurchaseHistoryListObject();
		lenient().when(viewOperationsMapper.createResponseToViewPurchaseHistory(Mockito.anyList())).thenReturn(purchaseHistory);
		
		assertNotNull(viewOperationsService.handleViewPurchaseHistory("ferfer"));
	}
}
