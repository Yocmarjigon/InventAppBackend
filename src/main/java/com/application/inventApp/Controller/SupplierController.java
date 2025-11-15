package com.application.inventApp.Controller;

import com.application.inventApp.Controller.DTO.SupplierDTOs.SupplierDTOFind;
import com.application.inventApp.Controller.DTO.SupplierDTOs.SupplierDTOSave;
import com.application.inventApp.Controller.DTO.SupplierDTOs.SupplierDTOUpdate;
import com.application.inventApp.Controller.Response.ResponseOK;
import com.application.inventApp.Entity.Supplier;
import com.application.inventApp.Exception.NotFoundException;
import com.application.inventApp.Services.Impl.SupplierService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/find-all")
    public ResponseEntity<?> findAll() {
        List<SupplierDTOFind> suppliers = supplierService
            .findAll()
            .stream()
            .map(supplier -> modelMapper.map(supplier, SupplierDTOFind.class))
            .toList();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/find-id/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Supplier> supplier = supplierService.findById(
            UUID.fromString(id)
        );

        if (supplier.isPresent()) {
            Supplier supplierUp = supplier.get();
            SupplierDTOFind supplierDTO = modelMapper.map(
                supplierUp,
                SupplierDTOFind.class
            );
            return ResponseEntity.ok(supplierDTO);
        }
        throw new NotFoundException("El proveedor no existe");
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(
        @Valid @RequestBody SupplierDTOSave supplierDTO,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(
                new ResponseOK(
                    bindingResult.getFieldError().getDefaultMessage()
                ),
                HttpStatus.BAD_REQUEST
            );
        }

        Supplier supplier = modelMapper.map(supplierDTO, Supplier.class);
        supplierService.save(supplier);
        return ResponseEntity.ok(
            new ResponseOK("El proveedor se ha creado correctamente")
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
        @PathVariable String id,
        @Valid @RequestBody SupplierDTOUpdate supplierDTO,
        BindingResult bindingResult
    ) {
        Supplier supplier = modelMapper.map(supplierDTO, Supplier.class);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(
                new ResponseOK(
                    bindingResult.getFieldError().getDefaultMessage()
                ),
                HttpStatus.BAD_REQUEST
            );
        }

        Optional<Supplier> supplierOptional = supplierService.update(
            UUID.fromString(id),
            supplier
        );

        if (supplierOptional.isPresent()) {
            return ResponseEntity.ok(
                new ResponseOK("El proveedor se actualizó correctamente")
            );
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Supplier> supplierOptional = supplierService.delete(
            UUID.fromString(id)
        );
        if (supplierOptional.isPresent()) {
            return ResponseEntity.ok(
                new ResponseOK("El proveedor se eliminó correctamente")
            );
        }
        throw new NotFoundException("El proveedor no existe");
    }
}
