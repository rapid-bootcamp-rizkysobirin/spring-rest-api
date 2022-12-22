package com.rapidtech.restapi.repository;

import com.rapidtech.restapi.entity.ShipperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepo extends JpaRepository<ShipperEntity, Long> {
}
