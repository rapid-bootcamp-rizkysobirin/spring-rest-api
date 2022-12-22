package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.PurchaseOrderDetailModel;
import com.rapidtech.restapi.model.PurchaseOrderModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "po_tab")
public class PurchaseOrderEntity {
    @Id
    @TableGenerator(name = "po_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="po_id", initialValue=0, allocationSize=0)

    @GeneratedValue(strategy = GenerationType.TABLE, generator = "po_id_generator")
    private Long id;

    @Column(name = "po_code", length = 20, nullable = false)
    private String poCode;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "shipper_id", nullable = false)
    private Long shipperId;

    @Temporal(TemporalType.DATE)
    @Column(name = "po_date", nullable = false)
    private Date poDate;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipper_id", insertable = false, updatable = false)
    private ShipperEntity shipper;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private EmployeeEntity employee;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PurchaseOrderDetailEntity> purchaseOrderDetails = new HashSet<>();

    public PurchaseOrderEntity(PurchaseOrderModel model) {
//        this.poCode = model.getPoCode();
//        this.customerId = model.getCustomerId();
//        this.employeeId = model.getEmployeeId();
//        this.shipperId = model.getShipperId();
//        this.poDate = model.getPoDate();
        BeanUtils.copyProperties(model,this);
    }

    public void addDetail(PurchaseOrderDetailEntity detailEntity){
        this.purchaseOrderDetails.add(detailEntity);
        detailEntity.setPurchaseOrder(this);
    }

    public void addDetailList(List<PurchaseOrderDetailModel> details){
        for(PurchaseOrderDetailModel item: details){
            PurchaseOrderDetailEntity detailEntity = new PurchaseOrderDetailEntity(item);
            addDetail(detailEntity);
        }
    }

}
