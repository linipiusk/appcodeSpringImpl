package com.ecommerce.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.java.entity.ProductsDetails_entity;

@Repository
public interface ViewOperationsRepository extends JpaRepository<ProductsDetails_entity, String> {

	@Query(value = "SELECT * FROM products_details p WHERE p.seller_username= :username", nativeQuery = true)
	List<ProductsDetails_entity> findAllProductsOfSeller(@Param("username") String username);
	
	@Query(value = "SELECT * FROM products_details p WHERE p.seller_username= :username and p.product_category = :prodCategory", nativeQuery = true)
	List<ProductsDetails_entity> findProductsOfSellerBasedOnCategory(@Param("username") String username, @Param("prodCategory") String prodCategory);
	
	@Query(value = "SELECT * FROM products_details p WHERE p.product_category = :prodCategory", nativeQuery = true)
	List<ProductsDetails_entity> findProductsForBuyerBasedOnCategory(@Param("prodCategory") String prodCategory);	
	
}
