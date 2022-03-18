package com.ecommerce.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.java.entity.ShoppingCart_entity;

@Repository
public interface BuyerOperationsRepository extends JpaRepository<ShoppingCart_entity, String> {

	@Query(value = "select * from shopping_cart s where s.buyer_username = :username and s.checkout_status = 'AddedToCart'", nativeQuery = true)
	List<ShoppingCart_entity> viewCart(@Param("username") String username);
	
	@Modifying
	@Query(value = "update shopping_cart s\r\n"
			+ "set s.checkout_status = :checkoutStatus\r\n"
			+ "where s.buyer_username = :username\r\n"
			+ "and s.selected_prod_id = :selectedProdID\r\n"
			+ "and s.order_id = :orderId", nativeQuery = true)
    void updateCheckoutStatus(@Param("checkoutStatus") String checkoutStatus, @Param("username") String username,
    		@Param("selectedProdID") String selectedProdID, @Param("orderId") String orderId);
}
