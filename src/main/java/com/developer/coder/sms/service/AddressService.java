package com.developer.coder.sms.service;


import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.entity.Address;

import java.util.List;

public interface AddressService {
    Addressdto createAddress(Addressdto addressDto);
    List<Addressdto> getAllAddresses();
    Addressdto getAddressById(Integer id);
    Addressdto updateAddress(Integer id, Addressdto addressDto);
    void deleteAddress(Integer id);
}
