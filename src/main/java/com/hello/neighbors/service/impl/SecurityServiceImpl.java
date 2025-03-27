package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.BearerToken;
import com.hello.neighbors.entity.Role;
import com.hello.neighbors.entity.Subscriber;
import com.hello.neighbors.entity.User;
import com.hello.neighbors.repository.RoleRepository;
import com.hello.neighbors.repository.UserRepository;
import com.hello.neighbors.entity.dto.AuthenticationDto;
import com.hello.neighbors.entity.dto.RegistrationDto;
import com.hello.neighbors.entity.dto.UserDto;
import com.hello.neighbors.security.JwtUtilities;
import com.hello.neighbors.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SecurityServiceImpl implements SecurityService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private JwtUtilities jwtUtilities;

    ////////////////// Méthodes ////////////////

    @Override
    public ResponseEntity<Object> register(RegistrationDto registrationDto) {
        if (userRepository.existsByEmail(registrationDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Identifiant déjà utilisé");
        } else {
            Subscriber subscriber = new Subscriber();
            subscriber.setFirstname(registrationDto.getFirstname());
            subscriber.setLastname(registrationDto.getLastname());
            subscriber.setPseudonym(registrationDto.getPseudonym());
            subscriber.setEmail(registrationDto.getEmail());
            subscriber.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
            subscriber.setCity(registrationDto.getCity());
            subscriber.setStreet(registrationDto.getStreet());
            subscriber.setPostalCode(registrationDto.getPostalCode());
            subscriber.setIsInCity(registrationDto.getIsInCity());
            Role role = roleRepository.findByRoleName(registrationDto.getRoleName());
            subscriber.setRoles(Collections.singletonList(role));
            userRepository.save(subscriber);
            String token = jwtUtilities.generateToken(registrationDto.getEmail(), Collections.singletonList(role.getRoleName()));
            return ResponseEntity.status(HttpStatus.OK).body(new BearerToken(token , "Bearer "));
        }
    }

    @Override
    public ResponseEntity<UserDto> authenticate(AuthenticationDto authenticationDto) {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationDto.getEmail(),
                        authenticationDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByEmail(authentication.getName());
        List<String> rolesNames = new ArrayList<>();
        user.getRoles().forEach(role-> rolesNames.add(role.getRoleName()));
        String token = jwtUtilities.generateToken(user.getUsername(),rolesNames);
        UserDto userDto = new UserDto(user.getId(), user.getFirstname(), user.getLastname(), token);
        return ResponseEntity.ok(userDto);
    }

    ////////////////// Setters ////////////////

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setJwtUtilities(JwtUtilities jwtUtilities) {
        this.jwtUtilities = jwtUtilities;
    }
}
