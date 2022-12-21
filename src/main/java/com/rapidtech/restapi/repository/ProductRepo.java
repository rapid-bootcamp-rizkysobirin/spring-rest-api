package com.rapidtech.restapi.repository;

import com.rapidtech.restapi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,Integer> {

}
