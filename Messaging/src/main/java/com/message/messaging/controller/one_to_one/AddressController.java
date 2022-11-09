package com.message.messaging.controller.one_to_one;

import com.message.messaging.dto.one_to_one.AddressDto;
import com.message.messaging.dto.one_to_one.UserDto;
import com.message.messaging.entity_deneme.one_to_one.User;
import com.message.messaging.repository.one_to_one.UserRepository;
import com.message.messaging.service.one_to_one.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/one-to-one")
public class AddressController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressService addressService;

    @PostMapping("/user/{userId}/save_address")
    public ResponseEntity<AddressDto> saveAddress(@PathVariable(name = "userId") Long userId, @RequestBody AddressDto addressDto){
        AddressDto addressDto1 = addressService.saveAddress(addressDto, userId);
        return new ResponseEntity<>(addressDto1, HttpStatus.CREATED);
    }
}
