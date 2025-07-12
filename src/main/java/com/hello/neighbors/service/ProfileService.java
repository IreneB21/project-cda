package com.hello.neighbors.service;

import com.hello.neighbors.entity.User;
import com.hello.neighbors.entity.dto.ProfileUpdateBioDto;
import com.hello.neighbors.entity.dto.ProfileUpdateDto;
import com.hello.neighbors.entity.dto.UserGetForVisitorDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ProfileService {

    ResponseEntity<Object> update(ProfileUpdateDto dto);
    User getUserInfos(long id);
    ResponseEntity<Object> updateBio(ProfileUpdateBioDto dto);
    UserGetForVisitorDto getUserInfosForVisitor(long id);
    Map<String, List<?>> getUserPosts(long id);
}
