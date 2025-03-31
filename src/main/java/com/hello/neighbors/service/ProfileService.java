package com.hello.neighbors.service;

import com.hello.neighbors.entity.Subscriber;
import com.hello.neighbors.entity.dto.ProfileUpdateDto;
import org.springframework.http.ResponseEntity;

public interface ProfileService {

    ResponseEntity<Object> update(ProfileUpdateDto dto);
}
