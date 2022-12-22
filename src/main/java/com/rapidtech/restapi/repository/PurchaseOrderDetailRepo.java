package com.rapidtech.restapi.repository;

import com.rapidtech.restapi.entity.PurchaseOrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderDetailRepo extends JpaRepository<PurchaseOrderDetailEntity, Long> {
}
