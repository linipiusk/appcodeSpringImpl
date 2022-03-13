package com.ecommerce.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.java.entity.PurchaseHistory_entity;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory_entity, String> {

}
