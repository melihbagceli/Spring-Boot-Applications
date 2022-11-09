package com.message.messaging.service.one_to_one;

import com.message.messaging.dto.one_to_one.UserDto;
import org.springframework.stereotype.Service;


public interface UserService {
    UserDto saveUser(UserDto userDto);
    UserDto getUser(Long userId);
}
