package com.ecommerce.test.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ecommerce.java.mapper.SellerOperationsMapper;
import com.ecommerce.java.model.ProductsDetails;
import com.ecommerce.test.fixtures.ProductsDetails_Fixture;

@RunWith(MockitoJUnitRunner.class)
public class SellerOperationsMapperTest {

	@InjectMocks
	SellerOperationsMapper sellerOperationsMapper;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	public void createDBObjectsForAdd_test() {
		
		List<ProductsDetails> prdtDetails = ProductsDetails_Fixture.createProductsDetailsListObject();
		assertNotNull(sellerOperationsMapper.createDBObjectsForAdd(prdtDetails, "hjdd"));
	}
	
	public void createDBObjectsForUpdateCount_test() {
		
		List<ProductsDetails> prdtDetails = ProductsDetails_Fixture.createProductsDetailsListObject();
		assertNotNull(sellerOperationsMapper.createDBObjectsForUpdateCount(prdtDetails, "kjsh"));
	}
	
	public void createDBObjectsForUpdatePrice_test() {
		
		List<ProductsDetails> prdtDetails = ProductsDetails_Fixture.createProductsDetailsListObject();
		assertNotNull(sellerOperationsMapper.createDBObjectsForUpdatePrice(prdtDetails, "ffr"));
	}
	
}
