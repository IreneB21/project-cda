package com.hello.neighbors.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
    @Value("${front.url}")
    private String frontUrl;

    @GetMapping(value = "test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("OK " + frontUrl);
    }
}

