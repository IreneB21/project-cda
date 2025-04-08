package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.Subscriber;
import com.hello.neighbors.entity.User;
import com.hello.neighbors.entity.dto.ProfileUpdateBioDto;
import com.hello.neighbors.entity.dto.ProfileUpdateDto;
import com.hello.neighbors.repository.UserRepository;
import com.hello.neighbors.service.ProfileService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private static final Logger logger = LogManager.getLogger();

    private UserRepository userRepository;

    ////////////////// Méthodes ////////////////

    @Override
    public ResponseEntity<Object> update(ProfileUpdateDto dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Identifiant déjà utilisé");
        } else {
            Subscriber existingUser = (Subscriber) userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found"));

            existingUser.setLastname(dto.getLastname());
            existingUser.setFirstname(dto.getFirstname());
            existingUser.setPseudonym(dto.getPseudonym());
            existingUser.setPassword(dto.getPassword()); // Consider encoding password
            existingUser.setEmail(dto.getEmail());
            existingUser.setCity(dto.getCity());
            existingUser.setPostalCode(dto.getPostalCode());
            existingUser.setStreet(dto.getStreet());
            existingUser.setIsInCity(dto.isInCity());
            existingUser.setBirthdate(dto.getBirthdate());
            existingUser.setIntroduction(dto.getIntroduction());
            existingUser.setPhone(dto.getPhone());
            existingUser.setPicture(dto.getPicture());
            existingUser.setNotificationPreferences(dto.getNotificationPreferences());

            return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(existingUser));
        }
    }

    @Override
    public User getUserInfos(long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public ResponseEntity<Object> updateBio(ProfileUpdateBioDto dto) {
        logger.info("User ID : " + dto.getUserId());
        Subscriber existingUser = (Subscriber) userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        existingUser.setIntroduction(dto.getBody());
        logger.info("Présentation : " + dto.getBody());
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(existingUser));
    }

    ////////////////// Setters ////////////////

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
