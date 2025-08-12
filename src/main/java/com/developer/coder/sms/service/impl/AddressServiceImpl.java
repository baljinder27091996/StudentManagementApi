package com.developer.coder.sms.service.impl;

import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.entity.Address;
import com.developer.coder.sms.exception.ResourceNotFoundException;
import com.developer.coder.sms.repository.AddressRepository;
import com.developer.coder.sms.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address createAddress(Addressdto addressDTO) {
        Address address = new Address(
                addressDTO.getstreet(),
                addressDTO.getcity(),
                addressDTO.getstate(),
                addressDTO.getzipcode()
        );
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(Integer id) {
        return Optional.ofNullable(addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id)));
    }

    @Override
    public Address updateAddress(Integer id, Addressdto addressDTO) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));

        address.setStreet(addressDTO.getstreet());
        address.setCity(addressDTO.getcity());
        address.setState(addressDTO.getstate());
        address.setZip(addressDTO.getzipcode());

        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Integer id) {
        if (!addressRepository.existsById(id)) {
            throw new ResourceNotFoundException("Address not found with id: " + id);
        }
        addressRepository.deleteById(id);
    }
}
