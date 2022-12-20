package com.rapidtech.restapi.service.impl;

import com.rapidtech.restapi.model.Product;
import com.rapidtech.restapi.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Optional<Product> getById() {
        return Optional.empty();
    }

    @Override
    public Optional<Product> save(Product model) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> update(Integer id, Product model) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> delete(Integer id) {
        return Optional.empty();
    }
}
