package com.developer.coder.sms.mapper;

import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.entity.Address;

public class AddressMapper {

    public static Addressdto mapToAddressDto(Address address) {
        if (address == null) {
            return null;
        }
        return new Addressdto(
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZip()
        );
    }

    public static Address mapToAddress(Addressdto addressDto) {
        if (addressDto == null) {
            return null;
        }
        return new Address(
                addressDto.getstreet(),
                addressDto.getcity(),
                addressDto.getstate(),
                addressDto.getzipcode()
        );
    }
}
