package com.developer.coder.sms.controller;

import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // ✅ Create new address
    @PostMapping
    public ResponseEntity<Addressdto> createAddress(@Valid @RequestBody Addressdto addressDto) {
        Addressdto savedAddress = addressService.createAddress(addressDto);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

    // ✅ Get all addresses
    @GetMapping
    public ResponseEntity<List<Addressdto>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    // ✅ Get a single address by ID
    @GetMapping("/{id}")
    public ResponseEntity<Addressdto> getAddressById(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    // ✅ Update address by ID
    @PutMapping("/{id}")
    public ResponseEntity<Addressdto> updateAddress(
            @PathVariable Integer id,
            @Valid @RequestBody Addressdto addressDto) {

        return ResponseEntity.ok(addressService.updateAddress(id, addressDto));
    }

    // ✅ Delete address by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
