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
    private int id;
    private String code;
    private  String name;
    private Double price;
    private Integer categoryId;
    private String categoryName;

    public ProductModel(ProductEntity entity){
        //copy entiti ini ke...
        /*
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.categoryId = entity.getCategoryId();
        this.categoryName = entity.getCategory().getName();
         */

        BeanUtils.copyProperties(entity, this);
        if(entity.getCategory() != null) {
            this.categoryName = entity.getCategory().getName();
        }
    }
    public ProductModel(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
