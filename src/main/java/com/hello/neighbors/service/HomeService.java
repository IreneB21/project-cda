package com.hello.neighbors.service;

import java.util.List;
import java.util.Map;

public interface HomeService {
    Map<String, List<?>> getAllPublicationsAndEvents();
    List<String> getRandomPictures();
    Map<String, List<?>> getNearbyPublicationsAndEvents(double lat, double lng, double radiusKm);
}
