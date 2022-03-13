package com.ecommerce.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.java.entity.ProductsDetails_entity;


@Repository
public interface ProductsRepository extends JpaRepository<ProductsDetails_entity, String> {

	@Modifying
	@Query(value = "update products_details p\r\n"
			+ "set p.product_count = p.product_count- :prodCount\r\n"
			+ "where p.product_id = :selectedProdID", nativeQuery = true)
    void updateProductsCount(@Param("prodCount") String prodCount, @Param("selectedProdID") String selectedProdID);
}
