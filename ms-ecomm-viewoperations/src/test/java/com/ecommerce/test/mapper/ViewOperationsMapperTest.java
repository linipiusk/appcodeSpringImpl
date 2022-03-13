package com.ecommerce.test.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ecommerce.java.entity.ProductsDetails_entity;
import com.ecommerce.java.entity.PurchaseHistory_entity;
import com.ecommerce.java.mapper.ViewOperationsMapper;
import com.ecommerce.test.Fixture.ProductsDetails_Fixture;
import com.ecommerce.test.Fixture.PurchaseHistory_Fixture;

@RunWith(MockitoJUnitRunner.class)
public class ViewOperationsMapperTest {

	@InjectMocks
	ViewOperationsMapper viewOperationsMapper;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createResponseToViewAllProducts_test() {
		
		List<ProductsDetails_entity> prdList = ProductsDetails_Fixture.createProductsDetailsListDBObject();
		assertNotNull(viewOperationsMapper.createResponseToViewAllProducts(prdList));
	}
	
	@Test
	public void createResponseToViewPurchaseHistory_test() {
		
		List<PurchaseHistory_entity> prdList = PurchaseHistory_Fixture.createPurchaseHistoryEntityListObject();
		assertNotNull(viewOperationsMapper.createResponseToViewPurchaseHistory(prdList));
	}
}
