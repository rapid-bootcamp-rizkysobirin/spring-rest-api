package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private Long id;
    private String code;
    private String name;
    private Double price;
    private Integer categoryId;
    private String categoryName;
    private Long supplierId;

    public ProductModel(ProductEntity entity){// ->ini
        //copy entiti ini ke... sini

//        this.id = entity.getId();
//        this.name = entity.getName();
//        this.price = entity.getPrice();
//        this.categoryId = entity.getCategoryId();
//        this.categoryName = entity.getCategory().getName();

        BeanUtils.copyProperties(entity, this);
        if(entity.getCategory() != null) {
            this.categoryName = entity.getCategory().getName();
        }
    }
    public ProductModel(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
