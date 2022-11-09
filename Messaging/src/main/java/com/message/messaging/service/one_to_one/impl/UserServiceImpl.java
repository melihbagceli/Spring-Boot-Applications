package com.message.messaging.service.one_to_one.impl;

import com.message.messaging.dto.one_to_one.UserDto;
import com.message.messaging.entity_deneme.one_to_one.Address;
import com.message.messaging.entity_deneme.one_to_one.User;
import com.message.messaging.repository.one_to_one.one_to_one.ResourceExistsException;
import com.message.messaging.repository.one_to_one.UserRepository;
import com.message.messaging.repository.one_to_one.one_to_one.ResourceNotFoundException;
import com.message.messaging.service.one_to_one.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        String username = userDto.getUsername();
        User user = userRepository.findByUsername(username);
        if (user != null) {
            throw new ResourceExistsException("User", "username", username);
        } else {
            try{
                User userInDb = userRepository.save(mapToEntity(userDto));
                return entityToDto(userInDb);
            } catch (Exception e){
                throw new ResourceExistsException("User", "username", username);
            }
        }
    }

    @Override
    public UserDto getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) throw new ResourceNotFoundException("User","Id",userId.toString());
        else {
            User user1 = user.get();
            Address address = user1.getAddress();
            return entityToDto(user1);
        }
    }

    private User mapToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private UserDto entityToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

}
