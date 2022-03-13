package com.ecommerce.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.java.entity.PurchaseHistory_entity;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory_entity, String> {

	@Query (value = "SELECT * FROM buyer_purchase_history b WHERE b.buyer_username = :username ORDER BY b.purchased_time DESC", nativeQuery = true)
	List<PurchaseHistory_entity> findPurchaseHistoryBasedOnUsername(@Param("username") String username);
}
