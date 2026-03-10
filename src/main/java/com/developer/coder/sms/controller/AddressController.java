package com.developer.coder.sms.controller;

import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.entity.Address;
import com.developer.coder.sms.exception.ResourceNotFoundException;
import com.developer.coder.sms.service.AddressService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    private final AddressService addressService;
    private final ModelMapper modelMapper;

    public AddressController(AddressService addressService, ModelMapper modelMapper) {
        this.addressService = addressService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<Addressdto> createAddress(@RequestBody Addressdto addressDTO) {
        logger.info("Creating new address: {}", addressDTO);
        Address address = addressService.createAddress(addressDTO);
        logger.info("Address created successfully with ID: {}", address.getId());
        return ResponseEntity
                .status(201)
                .body(convertToDto(address));
    }

    @GetMapping
    public ResponseEntity<List<Addressdto>> getAllAddresses() {
        logger.info("Fetching all addresses");
        List<Addressdto> addresses = addressService.getAllAddresses()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        logger.info("Total addresses fetched: {}", addresses.size());
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Addressdto> getAddressById(@PathVariable Integer id) {
        logger.info("Fetching address with ID: {}", id);
        Address address = addressService.getAddressById(id)
                .orElseThrow(() -> {
                    logger.error("Address not found with ID: {}", id);
                    return new ResourceNotFoundException("Address not found with id: " + id);
                });
        return ResponseEntity.ok(convertToDto(address));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Addressdto> updateAddress(@PathVariable Integer id, @RequestBody Addressdto addressDTO) {
        logger.info("Updating address with ID: {}", id);
        Address updatedAddress = addressService.updateAddress(id, addressDTO);
        logger.info("Address updated successfully with ID: {}", id);
        return ResponseEntity.ok(convertToDto(updatedAddress));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer id) {
        logger.info("Deleting address with ID: {}", id);
        addressService.deleteAddress(id);
        logger.info("Address deleted successfully with ID: {}", id);
        return ResponseEntity.ok("Address deleted successfully");
    }

    private Addressdto convertToDto(Address address) {
        return modelMapper.map(address, Addressdto.class);
    }
}
