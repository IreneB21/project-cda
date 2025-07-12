package com.hello.neighbors.controller.rest;

import com.hello.neighbors.entity.User;
import com.hello.neighbors.entity.dto.ProfileUpdateBioDto;
import com.hello.neighbors.entity.dto.ProfileUpdateDto;
import com.hello.neighbors.entity.dto.UserGetForVisitorDto;
import com.hello.neighbors.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/rest/hello/neighbors/profile")
@CrossOrigin("${front.url}")
public class ProfileRestController {

    private ProfileService profileService;

    //////////////// Endpoints ////////////////

    @GetMapping("/user/{id}/infos")
    public User getUserInfos(@PathVariable long id) {
        return profileService.getUserInfos(id);
    }

    @GetMapping("/user/{id}/infos/visitor")
    public UserGetForVisitorDto getUserInfosForVisitor(@PathVariable long id) {
        return profileService.getUserInfosForVisitor(id);
    }

    @GetMapping("/user/{id}/posts")
    public Map<String, List<?>> getUserPosts(@PathVariable long id) {
        return profileService.getUserPosts(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateProfile(@RequestBody ProfileUpdateDto dto) {
         return profileService.update(dto);
    }

    @PutMapping("/update/bio")
    public ResponseEntity<Object> updateBio(@RequestBody ProfileUpdateBioDto dto) {
        return profileService.updateBio(dto);
    }

    @Autowired
    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }
}
