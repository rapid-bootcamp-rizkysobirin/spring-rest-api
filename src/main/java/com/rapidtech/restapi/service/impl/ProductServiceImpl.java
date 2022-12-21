package com.rapidtech.restapi.service.impl;

import com.rapidtech.restapi.entity.ProductEntity;
import com.rapidtech.restapi.model.ProductModel;
import com.rapidtech.restapi.repository.ProductRepo;
import com.rapidtech.restapi.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    //untuk mengambil data menggunakan repository
    private ProductRepo repo;
    @Autowired
    public ProductServiceImpl(ProductRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<ProductModel> getAll() {
        //===ProductModel== sama dengan product model diberi parameter entity
        return this.repo.findAll().stream().map(ProductModel::new)
                .collect(Collectors.toList());
        //cara sebenarnya
//        return this.repo.findAll().stream().map(item->new ProductModel(item))
//                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductModel> getById(Integer id) {
        if (id == 0) {
            return Optional.empty();
        }
        //buat variable dulu
        Optional<ProductEntity> result = this.repo.findById(id);
        /* aslinya gini
        if (result.isEmpty()){
            return Optional.empty();
        }else{//bisa gini
            return Optional.of(new ProductModel(result.get()));
        }
         */
        //direplace jadi ini
        return result.map(ProductModel::new);
    }

    @Override
    public Optional<ProductModel> save(ProductModel model) {
        if(model == null){
            return Optional.empty();
        }
//        kita akan mengopi satu2
        ProductEntity entity =  new ProductEntity(model);
        //biasanya gini -> diganti parameter new product model
//        entity.setId(model.getId());
//        entity.setName(model.getCode());
//        entity.setCode(model.getName());
        try{//karena ada kemungkinan error
            this.repo.save(entity);
            return Optional.of(new ProductModel(entity));
        }catch (Exception e){
            log.error("Product save is failed, error {}", e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public Optional<ProductModel> update(Integer id, ProductModel model) {
        if (id == 0) {
            return Optional.empty();
        }
        ProductEntity result = this.repo.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }

        //copy property (dari model --> result)
        BeanUtils.copyProperties(model, result);
        //habis copy di simpan
        try{//karena ada kemungkinan error
            this.repo.save(result);
            return Optional.of(new ProductModel(result));
        }catch (Exception e){
            log.error("Product update is failed, error {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductModel> delete(Integer id) {
        if (id == 0) {
            return Optional.empty();
        }
        ProductEntity result = this.repo.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }
        try{//karena ada kemungkinan error
            this.repo.delete(result);
            return Optional.of(new ProductModel(result));
        }catch (Exception e){
            log.error("Product delete is failed, error {}", e.getMessage());
            return Optional.empty();
        }
    }
}
