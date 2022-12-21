package com.rapidtech.restapi.repository;

import com.rapidtech.restapi.entity.CategoryEntity;
import com.rapidtech.restapi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {

}
