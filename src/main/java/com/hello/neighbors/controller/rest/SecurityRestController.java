package com.hello.neighbors.controller.rest;

import com.hello.neighbors.entity.dto.AuthenticationDto;
import com.hello.neighbors.entity.dto.RegistrationDto;
import com.hello.neighbors.entity.dto.UserDto;
import com.hello.neighbors.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rest/hello/neighbors/security")
@CrossOrigin("${front.url}")
public class SecurityRestController {

    private SecurityService securityService;

    //////////////// Endpoints ////////////////

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody RegistrationDto registrationDto) {
        return securityService.register(registrationDto);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserDto> authenticate(@RequestBody AuthenticationDto authenticationDto) {
        return securityService.authenticate(authenticationDto);
    }

    //////////////// Setters ////////////////

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }
}
