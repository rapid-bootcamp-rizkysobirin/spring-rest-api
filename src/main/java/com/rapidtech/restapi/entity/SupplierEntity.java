package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.SupplierModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor //untuk empty constructor
@Table( name = "suplier_tab")
public class SupplierEntity {
    @Id
    @TableGenerator(name = "supplier_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="supplier_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "supplier_id_generator")
    private Long id;

    @Column(name = "supplier_name", length = 100, nullable = false)
    private String supplierName;

    @Column(name = "contact_name", length = 100, nullable = false)
    private String contactName;
    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "phone", length = 20)
    private String phone;

    @OneToMany(mappedBy = "supplier")
    private Set<ProductEntity> products = new HashSet<>();

    public SupplierEntity(SupplierModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
