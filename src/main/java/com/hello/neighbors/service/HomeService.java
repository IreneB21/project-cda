package com.hello.neighbors.service;

import com.hello.neighbors.entity.dto.EventGetDto;
import com.hello.neighbors.entity.dto.PostDto;

import java.util.List;
import java.util.Map;

public interface HomeService {
    Map<String, List<?>> getAllPublicationsAndEvents();
    List<String> getRandomPictures();
    Map<String, List<PostDto>> getNearbyPublicationsAndEvents(long userId);
    List<EventGetDto> getNextThreeNearbyEvents(long userId);
    Long getTotalUsersAround(long userId);
}
