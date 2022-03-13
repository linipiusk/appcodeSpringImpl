package com.ecommerce.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.java.entity.ProductsDetails_entity;

@Repository
public interface SellerOperationsRepository extends JpaRepository<ProductsDetails_entity, String>{

	@Modifying
	@Query(value = "update products_details p set p.product_count = :productCount WHERE p.product_id = :productId", nativeQuery = true)
    void setProductCount(@Param("productId") String productId, @Param("productCount") String productCount);
	
	@Modifying
	@Query(value = "update products_details p set p.product_price = :productPrice WHERE p.product_id = :productId", nativeQuery = true)
    void setProductPrice(@Param("productId") String productId, @Param("productPrice") String productPrice);
}
