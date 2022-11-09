package com.message.messaging.controller.one_to_one;

import com.message.messaging.dto.one_to_one.UserDto;
import com.message.messaging.service.one_to_one.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/one-to-one")
public class UserController {
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto userDtoInDb = userService.saveUser(userDto);
        return new ResponseEntity<>(userDtoInDb, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable(name = "userId") Long userId){
        UserDto userDtoInDb = userService.getUser(userId);
        return new ResponseEntity<>(userDtoInDb, HttpStatus.OK);
    }
}
