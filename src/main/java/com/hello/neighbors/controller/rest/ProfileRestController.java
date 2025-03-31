package com.hello.neighbors.controller.rest;

import com.hello.neighbors.entity.Subscriber;
import com.hello.neighbors.entity.dto.ProfileUpdateDto;
import com.hello.neighbors.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rest/hello/neighbors/profile")
@CrossOrigin("${front.url}")
public class ProfileRestController {

    private ProfileService profileService;

    //////////////// Endpoints ////////////////

    @PutMapping("/update")
    public ResponseEntity<Object> updateProfile(@RequestBody ProfileUpdateDto dto) {
         return profileService.update(dto);
    }
}
