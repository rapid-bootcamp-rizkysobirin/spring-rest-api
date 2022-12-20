package com.rapidtech.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table( name = "product_tab")
@AllArgsConstructor
public class ProductEntity {
    private Integer id;
    private String name;
    private Double price;

}
