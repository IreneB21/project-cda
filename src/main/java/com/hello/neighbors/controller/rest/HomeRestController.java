package com.hello.neighbors.controller.rest;

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

    @GetMapping("/display/all/nearby")
    public Map<String, List<?>> getNearbyPublicationsAndEvents(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam double radiusKm) {
        return homeService.getNearbyPublicationsAndEvents(lat, lng, radiusKm);
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
