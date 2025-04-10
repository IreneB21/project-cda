package com.hello.neighbors.service;

import java.util.HashMap;
import java.util.List;

public interface HomeService {
    HashMap<String, Object> getAllPublicationsAndEvents();
    List<String> getRandomPictures();
}
