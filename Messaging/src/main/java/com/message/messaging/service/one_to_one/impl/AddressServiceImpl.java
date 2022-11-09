package com.message.messaging.service.one_to_one.impl;

import com.message.messaging.dto.one_to_one.AddressDto;
import com.message.messaging.entity_deneme.one_to_one.Address;
import com.message.messaging.entity_deneme.one_to_one.User;
import com.message.messaging.repository.one_to_one.AddressRepository;
import com.message.messaging.repository.one_to_one.UserRepository;
import com.message.messaging.repository.one_to_one.one_to_one.ResourceNotFoundException;
import com.message.messaging.service.one_to_one.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    UserRepository userRepository;
    AddressRepository addressRepository;
    ModelMapper modelMapper;

    @Autowired
    public AddressServiceImpl(UserRepository userRepository, AddressRepository addressRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddressDto saveAddress(AddressDto addressDto, Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.isPresent()){
            User user = userOpt.get();
            Address address = dtoToEntity(addressDto);
            if(user.getAddress() != null)
                address.setId(user.getAddress().getId());
            user.setAddress(address);
            userRepository.save(user);
            return entityToDto(address);
        }
        else{
            throw new ResourceNotFoundException("User", "Id", userId.toString());
        }
    }

    private AddressDto entityToDto(Address address){
        return modelMapper.map(address, AddressDto.class);
    }

    private Address dtoToEntity(AddressDto addressDto){
        return modelMapper.map(addressDto, Address.class);
    }
}
