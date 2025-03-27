package com.hello.neighbors.service;

import com.hello.neighbors.entity.dto.AuthenticationDto;
import com.hello.neighbors.entity.dto.RegistrationDto;
import com.hello.neighbors.entity.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface SecurityService {

    ResponseEntity<Object> register(RegistrationDto registrationDto);
    ResponseEntity<UserDto> authenticate(AuthenticationDto authenticationDto);
}
