package com.developer.coder.sms.controller;
import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.entity.Address;
import com.developer.coder.sms.exception.ResourceNotFoundException;
import com.developer.coder.sms.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Addressdto addressDTO) {
        Address savedAddress = addressService.createAddress(addressDTO);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Integer id) {
        Address address = addressService.getAddressById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));
        return ResponseEntity.ok(address);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable  Integer id, @RequestBody Addressdto addressDTO) {
        Address updatedAddress = addressService.updateAddress(id, addressDTO);
        return ResponseEntity.ok(updatedAddress);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok("Address deleted successfully");
    }
}
