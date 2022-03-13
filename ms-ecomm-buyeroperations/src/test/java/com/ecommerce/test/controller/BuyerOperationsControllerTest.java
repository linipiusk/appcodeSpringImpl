package com.ecommerce.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import com.ecommerce.java.controller.BuyerOperationsController;
import com.ecommerce.java.model.ShoppingCart;
import com.ecommerce.java.model.ShoppingCartView;
import com.ecommerce.java.service.BuyerOperationsService;
import com.ecommerce.test.fixture.ShoppingCartFixture;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ BuyerOperationsController.class })
@AutoConfigureMockMvc
public class BuyerOperationsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	private BuyerOperationsService buyerOperationsService;
	
	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testBuyercheckout_success() throws Exception {
		
		List<ShoppingCart> cartList = ShoppingCartFixture.createShoppingCartListObject();
		Gson g = new Gson();
		String str = g.toJson(cartList);
		
		mockMvc.perform(post("/grocerystore/buyercheckout/lpk").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testViewShoppingcart_success() throws Exception {
		
		ShoppingCartView cartView = ShoppingCartFixture.createShoppingCartListObjectToView();
		when(buyerOperationsService.handleViewCart(Mockito.anyString())).thenReturn(cartView);
		
		mockMvc.perform(get("/grocerystore/viewshoppingcart/lpk").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testConfirmCheckoutSucccess_pass() throws Exception {
		
		List<ShoppingCart> cartList = ShoppingCartFixture.createShoppingCartListToCheckout();
		Gson g = new Gson();
		String str = g.toJson(cartList);
		
		mockMvc.perform(post("/grocerystore/confirmcheckout/lpk?checkoutstatus='SUCCESS'").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testConfirmCheckoutFailed_pass() throws Exception {
		
		List<ShoppingCart> cartList = ShoppingCartFixture.createShoppingCartListToCheckout();
		Gson g = new Gson();
		String str = g.toJson(cartList);
		
		mockMvc.perform(post("/grocerystore/confirmcheckout/lpk?checkoutstatus='FAILED'").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk()).andReturn();
	}
}
