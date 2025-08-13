package com.developer.coder.sms.mapper;

import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.entity.Address;

public class AddressMapper {

    public static Addressdto mapToAddressDto(Address address) {
        if (address == null) {
            return null;
        }
        return Addressdto.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .zipcode(address.getZip())
                .build();
    }

    public static Address mapToAddress(Addressdto addressDto) {
        if (addressDto == null) {
            return null;
        }
        return Address.builder()
                .street(addressDto.getStreet())
                .city(addressDto.getCity())
                .state(addressDto.getState())
                .zip(addressDto.getZipcode())
                .build();
    }
}
