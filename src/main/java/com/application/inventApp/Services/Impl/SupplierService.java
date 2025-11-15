package com.application.inventApp.Services.Impl;

import com.application.inventApp.Entity.Supplier;
import com.application.inventApp.Repository.SupplierRepository;
import com.application.inventApp.Services.ISupplierService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService implements ISupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAll() {
        return (List<Supplier>) supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> findById(UUID id) {
        return supplierRepository.findById(id);
    }

    @Override
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> update(UUID id, Supplier supplier) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (supplierOptional.isPresent()) {
            Supplier supplierUp = supplierOptional.get();

            supplierUp.setName(supplier.getName());
            supplierUp.setNumberPhone(supplier.getNumberPhone());
            supplierUp.setEmail(supplier.getEmail());
            supplierUp.setAddress(supplier.getAddress());

            supplierRepository.save(supplierUp);
        }
        return supplierOptional;
    }

    @Override
    public Optional<Supplier> delete(UUID id) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (supplierOptional.isPresent()) {
            supplierRepository.delete(supplierOptional.get());
        }
        return supplierOptional;
    }
}
