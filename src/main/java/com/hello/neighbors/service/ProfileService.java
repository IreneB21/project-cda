package com.hello.neighbors.service;

import com.hello.neighbors.entity.User;
import com.hello.neighbors.entity.dto.ProfileUpdateBioDto;
import com.hello.neighbors.entity.dto.ProfileUpdateDto;
import org.springframework.http.ResponseEntity;

public interface ProfileService {

    ResponseEntity<Object> update(ProfileUpdateDto dto);
    User getUserInfos(long id);
    ResponseEntity<Object> updateBio(ProfileUpdateBioDto dto);
}
