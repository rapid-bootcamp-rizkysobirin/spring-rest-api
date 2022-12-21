package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Data
@Entity
@Table( name = "product_tab")
@AllArgsConstructor
@NoArgsConstructor //untuk empty constructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// auto gk perlu tambah tabel tambahan klo sequence butuh tabel tambahan
    private Integer id;
    //untuk mrndefinisikan kolom
    @Column(name = "product_code", length = 20, nullable = false)
    private String Code;
    @Column(name = "product_name", length = 100, nullable = false)//kalau mau beda nama colom dan field nya
    private String name;
    @Column(name = "product_price")
    private Double price;
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", insertable = false,updatable = false)
    private CategoryEntity category;

    public ProductEntity(ProductModel model) {
//        this.code = model.getCode();
//        this.name = model.getName();
//        this.price = model.getPrice();
//        this.categoryId = model.getCategoryId();
//        diganti pakai ini
        BeanUtils.copyProperties(model,this);
    }
}
