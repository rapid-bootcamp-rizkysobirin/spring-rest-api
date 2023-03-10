package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor //untuk empty constructor
@Table( name = "product_tab")
public class ProductEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)// auto gk perlu tambah tabel tambahan klo sequence butuh tabel tambahan
    @TableGenerator(name = "id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="product_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
    private Long id; // ini alasan kenapa product repo Integer
    //untuk mrndefinisikan kolom
    @Column(name = "product_code", length = 20, nullable = false)
    private String code;
    @Column(name = "product_name", length = 100, nullable = false)//kalau mau beda nama colom dan field nya
    private String name;
    @Column(name = "product_price")
    private Double price;
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", insertable = false,updatable = false)
    private CategoryEntity category;// yg nantinya dipanggil di categoryEntity

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private SupplierEntity supplier;

    @OneToMany(mappedBy = "product")
    private Set<PurchaseOrderDetailEntity> purchaseOrderDetails = new HashSet<>();

    public ProductEntity(ProductModel model) {
//        this.code = model.getCode(); //-->gini
//        this.name = model.getName();
//        this.price = model.getPrice();
//        this.categoryId = model.getCategoryId();
//        diganti pakai ini
        // alamat: model , tujuan: id/this
        BeanUtils.copyProperties(model,this);
    }
}



