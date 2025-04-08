package com.hello.neighbors.controller.rest;

import com.hello.neighbors.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/rest/hello/neighbors/home")
@CrossOrigin("${front.url}")
public class HomeRestController {

    private HomeService homeService;

    //////////////// Endpoints ////////////////

    @GetMapping("/display/all")
    public List<Object> getAllPublicationsAndEvents() {
        return homeService.getAllPublicationsAndEvents();
    }

    @Autowired
    public void setHomeService(HomeService homeService) {
        this.homeService = homeService;
    }
}
