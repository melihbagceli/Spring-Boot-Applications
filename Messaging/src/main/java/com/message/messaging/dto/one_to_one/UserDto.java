package com.message.messaging.dto.one_to_one;
import com.message.messaging.entity_deneme.one_to_one.Address;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private Address address;
}
