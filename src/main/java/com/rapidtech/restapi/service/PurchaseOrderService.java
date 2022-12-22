package com.rapidtech.restapi.service;

import com.rapidtech.restapi.model.EmployeeModel;
import com.rapidtech.restapi.model.PurchaseOrderModel;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderService {
    List<PurchaseOrderModel> getAll();
    Optional<PurchaseOrderModel> getById(Long id);
    Optional<PurchaseOrderModel> save(PurchaseOrderModel model);
    Optional<PurchaseOrderModel> update(Long id, PurchaseOrderModel model);
    Optional<PurchaseOrderModel> delete(Long id);
}