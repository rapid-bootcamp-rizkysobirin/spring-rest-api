package com.rapidtech.restapi.repository;

import com.rapidtech.restapi.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<SupplierEntity, Long> {
}
