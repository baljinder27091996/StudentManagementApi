package com.developer.coder.sms.service.impl;

import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.entity.Address;
import com.developer.coder.sms.exception.ResourceNotFoundException;
import com.developer.coder.sms.mapper.AddressMapper;
import com.developer.coder.sms.repository.AddressRepository;
import com.developer.coder.sms.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Addressdto createAddress(Addressdto addressDto) {
        Address address = AddressMapper.mapToAddress(addressDto);
        Address saved = addressRepository.save(address);
        return AddressMapper.mapToAddressDto(saved);
    }

    @Override
    public List<Addressdto> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(AddressMapper::mapToAddressDto)
                .toList(); // Java 16+, use Collectors.toList() for Java 8
    }

    @Override
    public Addressdto getAddressById(Integer id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));
        return AddressMapper.mapToAddressDto(address);
    }

    @Override
    public Addressdto updateAddress(Integer id, Addressdto addressDto) {
        Address existing = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));

        existing.setStreet(addressDto.getstreet());
        existing.setCity(addressDto.getcity());
        existing.setState(addressDto.getstate());
        existing.setZip(addressDto.getzipcode());

        Address updated = addressRepository.save(existing);
        return AddressMapper.mapToAddressDto(updated);
    }

    @Override
    public void deleteAddress(Integer id) {
        if (!addressRepository.existsById(id)) {
            throw new ResourceNotFoundException("Address not found with id: " + id);
        }
        addressRepository.deleteById(id);
    }
}
