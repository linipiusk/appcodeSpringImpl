package com.ecommerce.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.ecommerce.java.controller.SellerOperationsController;
import com.ecommerce.java.model.ProductsDetails;
import com.ecommerce.java.service.SellerOperationsService;
import com.ecommerce.test.fixtures.ProductsDetails_Fixture;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ SellerOperationsController.class })
@AutoConfigureMockMvc
public class SellerOperationsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	private SellerOperationsService sellerOperationsService;
	
	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testAddproducts_success() throws Exception {
		
		List<ProductsDetails> details = ProductsDetails_Fixture.createProductsDetailsListObject();
		Gson g = new Gson();
		String str = g.toJson(details);
		
		mockMvc.perform(post("/grocerystore/addproducts/lpk").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testModifyCost_success() throws Exception {
		
		List<ProductsDetails> details = ProductsDetails_Fixture.createProductsDetailsListObject();
		Gson g = new Gson();
		String str = g.toJson(details);
		
		mockMvc.perform(patch("/grocerystore/modifycost/lpk").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testModifyCount_success() throws Exception {
		
		List<ProductsDetails> details = ProductsDetails_Fixture.createProductsDetailsListObject();
		Gson g = new Gson();
		String str = g.toJson(details);
		
		mockMvc.perform(patch("/grocerystore/modifycount/lpk").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk()).andReturn();
	}
}
