package com.rapidtech.restapi.service.impl;

import com.rapidtech.restapi.entity.PurchaseOrderEntity;
import com.rapidtech.restapi.model.PurchaseOrderModel;
import com.rapidtech.restapi.repository.PurchaseOrderDetailRepo;
import com.rapidtech.restapi.repository.PurchaseOrderRepo;
import com.rapidtech.restapi.service.PurchaseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private PurchaseOrderRepo orderRepo;

    private PurchaseOrderDetailRepo detailRepo;

    @Autowired
    public PurchaseOrderServiceImpl (PurchaseOrderRepo orderRepo, PurchaseOrderDetailRepo detailRepo){
        this.orderRepo = orderRepo;
        this.detailRepo = detailRepo;
    }
    @Override
    public List<PurchaseOrderModel> getAll() {
        return this.orderRepo.findAll().stream().map(PurchaseOrderModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PurchaseOrderModel> getById(Long id) {
        if(id == 0) {
            return Optional.empty();
        }
        Optional<PurchaseOrderEntity> result = this.orderRepo.findById(id);
        /*
        if(result.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(new ProductModel(result.get()));
         */
        return result.map(PurchaseOrderModel::new);
    }

    @Override
    public Optional<PurchaseOrderModel> save(PurchaseOrderModel model) {
//        if (model == null || model.getDetails().isEmpty()) {
//            return Optional.empty();
//        }
//
//        PurchaseOrderEntity entity = new PurchaseOrderEntity(model);
//        entity.addDetailList(model.getDetails());
//
//        try {
//            this.orderRepo.save(entity);
//            return Optional.of(model);
//        } catch (Exception e) {
//            log.error("Purchase Order save is failed, error: {}", e.getMessage());
//            return Optional.empty();
//        }
        return null;
    }

    @Override
    public Optional<PurchaseOrderModel> update(Long id, PurchaseOrderModel model) {
        if(id == 0) {
            return Optional.empty();
        }

        PurchaseOrderEntity result = this.orderRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        // copy property
        BeanUtils.copyProperties(model, result);
        try {
            this.orderRepo.save(result);
            return Optional.of(new PurchaseOrderModel(result));
        }catch (Exception e){
            log.error("Product update is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<PurchaseOrderModel> delete(Long id) {
        if(id == 0) {
            return Optional.empty();
        }

        PurchaseOrderEntity result = this.orderRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        try {
            this.orderRepo.delete(result);
            return Optional.of(new PurchaseOrderModel(result));
        }catch (Exception e){
            log.error("Product delete is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
