package com.hello.neighbors.controller.rest;

import com.hello.neighbors.entity.dto.PostDto;
import com.hello.neighbors.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/rest/hello/neighbors/home")
@CrossOrigin("${front.url}")
public class HomeRestController {

    private HomeService homeService;

    //////////////// Endpoints ////////////////

    @GetMapping("/display/all")
    public Map<String, List<?>> getAllPublicationsAndEvents() {
        return homeService.getAllPublicationsAndEvents();
    }

    @GetMapping("/display/all/nearby/{userId}")
    public Map<String, List<PostDto>> getNearbyPublicationsAndEvents(@PathVariable long userId) {
        return homeService.getNearbyPublicationsAndEvents(userId);
    }

    @GetMapping("/display/random/user/pictures")
    public List<String> getRandomUserPictures() {
        return homeService.getRandomPictures();
    }

    @Autowired
    public void setHomeService(HomeService homeService) {
        this.homeService = homeService;
    }
}
