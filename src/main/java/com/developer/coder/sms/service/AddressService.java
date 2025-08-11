package com.developer.coder.sms.service;


import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address createAddress(Addressdto addressDTO);
    List<Address> getAllAddresses();
    Optional<Address> getAddressById(Integer id);
    Address updateAddress(  Integer id, Addressdto addressDTO);
    void deleteAddress(Integer id);
}
