package com.ecommerce.test.service;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

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
import com.ecommerce.java.mapper.SellerOperationsMapper;
import com.ecommerce.java.model.ProductsDetails;
import com.ecommerce.java.repository.SellerOperationsRepository;
import com.ecommerce.java.service.SellerOperationsService;
import com.ecommerce.test.fixtures.ProductsDetails_Fixture;

@RunWith(MockitoJUnitRunner.class)
public class SellerOperationsServiceTest {

	@Mock
	SellerOperationsRepository sellerOperationsRepository;
	
	@Mock
	SellerOperationsMapper sellerOperationsMapper;
	
	@InjectMocks
	SellerOperationsService sellerOperationsService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void handleAddProductsTest() {
		
		List<ProductsDetails> prdtDetails = ProductsDetails_Fixture.createProductsDetailsListObject();
		List<ProductsDetails_entity> entityList = ProductsDetails_Fixture.createProductsDetailsListDBObject();
		lenient().when(sellerOperationsMapper.createDBObjectsForAdd(Mockito.anyList(), Mockito.any())).thenReturn(entityList);
		sellerOperationsService.handleAddProducts(prdtDetails, "jhgu");
	}
	
	@Test
	public void handleUpdateProductCountTest() {
		
		List<ProductsDetails> prdtDetails = ProductsDetails_Fixture.createProductsDetailsListObject();
		List<ProductsDetails_entity> entityList = ProductsDetails_Fixture.createProductsDetailsListDBObject();
		lenient().when(sellerOperationsMapper.createDBObjectsForUpdateCount(Mockito.anyList(), Mockito.any())).thenReturn(entityList);
		sellerOperationsService.handleUpdateProductCount(prdtDetails, "vdj");
	}
	
	@Test
	public void handleUpdateProductPriceTest() {
		
		List<ProductsDetails> prdtDetails = ProductsDetails_Fixture.createProductsDetailsListObject();
		List<ProductsDetails_entity> entityList = ProductsDetails_Fixture.createProductsDetailsListDBObject();
		lenient().when(sellerOperationsMapper.createDBObjectsForUpdatePrice(Mockito.anyList(), Mockito.any())).thenReturn(entityList);
		sellerOperationsService.handleUpdateProductPrice(prdtDetails, "vdj");
	}
}
