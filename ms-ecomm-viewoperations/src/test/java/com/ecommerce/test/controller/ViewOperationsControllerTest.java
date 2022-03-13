package com.ecommerce.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.ecommerce.java.controller.ViewOperationsController;
import com.ecommerce.java.model.ProductsDetails;
import com.ecommerce.java.model.PurchaseHistory;
import com.ecommerce.java.service.ViewOperationsService;
import com.ecommerce.test.Fixture.ProductsDetails_Fixture;
import com.ecommerce.test.Fixture.PurchaseHistory_Fixture;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ ViewOperationsController.class })
@AutoConfigureMockMvc
public class ViewOperationsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	private ViewOperationsService viewOperationsService;
	
	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testViewAllProducts_seller_success() throws Exception {
		
		List<ProductsDetails> details = ProductsDetails_Fixture.createProductsDetailsListObject();
		when(viewOperationsService.handleSellerViewAllProductDetails(Mockito.anyString())).thenReturn(details);
		
		mockMvc.perform(get("/grocerystore/viewallproducts/lpk?userrole='seller'").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testViewAllProducts_buyer_success() throws Exception {
		
		List<ProductsDetails> details = ProductsDetails_Fixture.createProductsDetailsListObject();
		when(viewOperationsService.handleSellerViewAllProductDetails(Mockito.anyString())).thenReturn(details);
		
		mockMvc.perform(get("/grocerystore/viewallproducts/lpk?userrole='buyer'").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testViewAllProducts_buyer_failure1() throws Exception {
		
		List<ProductsDetails> details = ProductsDetails_Fixture.createProductsDetailsListObject();
		when(viewOperationsService.handleSellerViewAllProductDetails(Mockito.anyString())).thenReturn(details);
		
		mockMvc.perform(get("/grocerystore/viewallproducts/lpk?userrole='abc'").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andReturn();
	}
	
	@Test
	public void testViewAllProducts_buyer_failure2() throws Exception {
		
		List<ProductsDetails> details = new ArrayList<>();
		when(viewOperationsService.handleSellerViewAllProductDetails(Mockito.anyString())).thenReturn(details);
		
		mockMvc.perform(get("/grocerystore/viewallproducts/lpk?userrole='seller'").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent()).andReturn();
	}
	
	@Test
	public void testViewProducts_seller_success() throws Exception {
		
		List<ProductsDetails> details = ProductsDetails_Fixture.createProductsDetailsListObject();
		when(viewOperationsService.handleSellerViewAllProductDetails(Mockito.anyString())).thenReturn(details);
		
		mockMvc.perform(get("/grocerystore/viewproducts/lpk?userrole='seller'&category='Snacks'").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testViewProducts_buyer_success() throws Exception {
		
		List<ProductsDetails> details = ProductsDetails_Fixture.createProductsDetailsListObject();
		when(viewOperationsService.handleSellerViewAllProductDetails(Mockito.anyString())).thenReturn(details);
		
		mockMvc.perform(get("/grocerystore/viewproducts/lpk?userrole='buyer'&category='Snacks'").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testViewProducts_buyer_failure1() throws Exception {
		
		List<ProductsDetails> details = ProductsDetails_Fixture.createProductsDetailsListObject();
		when(viewOperationsService.handleSellerViewAllProductDetails(Mockito.anyString())).thenReturn(details);
		
		mockMvc.perform(get("/grocerystore/viewproducts/lpk?userrole='abc'&category='Snacks'").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andReturn();
	}
	
	@Test
	public void testViewProducts_buyer_failure2() throws Exception {
		
		List<ProductsDetails> details = new ArrayList<>();
		when(viewOperationsService.handleSellerViewAllProductDetails(Mockito.anyString())).thenReturn(details);
		
		mockMvc.perform(get("/grocerystore/viewproducts/lpk?userrole='seller'&category='Snacks'").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent()).andReturn();
	}
	
	@Test
	public void testViewPurchaseHistory_success() throws Exception {
		
		List<PurchaseHistory> purchaseList = PurchaseHistory_Fixture.createPurchaseHistoryListObject();
		when(viewOperationsService.handleViewPurchaseHistory(Mockito.anyString())).thenReturn(purchaseList);
		
		mockMvc.perform(get("/grocerystore/viewpurchasehistory/lpk").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();		
	}
	
	@Test
	public void testViewPurchaseHistory_failure() throws Exception {
		
		List<PurchaseHistory> purchaseList = new ArrayList<>();
		when(viewOperationsService.handleViewPurchaseHistory(Mockito.anyString())).thenReturn(purchaseList);
		
		mockMvc.perform(get("/grocerystore/viewpurchasehistory/lpk").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent()).andReturn();		
	}
}
