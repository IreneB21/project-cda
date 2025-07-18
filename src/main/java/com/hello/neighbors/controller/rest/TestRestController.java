package com.hello.neighbors.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping(value = "test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("OK");
    }
}

