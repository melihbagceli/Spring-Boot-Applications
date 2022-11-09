package com.message.messaging.service.one_to_one;

import com.message.messaging.dto.one_to_one.AddressDto;


public interface AddressService {
    AddressDto saveAddress(AddressDto addressDto, Long userId);
}
