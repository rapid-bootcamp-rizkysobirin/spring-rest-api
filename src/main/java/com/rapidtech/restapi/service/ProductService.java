package com.rapidtech.restapi.service;

import com.rapidtech.restapi.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Optional<Product> getById();
    Optional<Product> save(Product model);
    Optional<Product> update(Integer id, Product model);
    Optional<Product> delete(Integer id);
}
