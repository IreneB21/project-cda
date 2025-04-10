package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.Event;
import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.repository.EventRepository;
import com.hello.neighbors.repository.PublicationRepository;
import com.hello.neighbors.repository.UserRepository;
import com.hello.neighbors.service.HomeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    private static final Logger logger = LogManager.getLogger();

    private PublicationRepository publicationRepository;
    private EventRepository eventRepository;
    private UserRepository userRepository;

    ////////////////// Méthodes ////////////////

    @Override
    public HashMap<String, Object> getAllPublicationsAndEvents() {
        HashMap<String, Object> allPosts = new HashMap<>();
        List<Publication> publications = publicationRepository.findAll();
        List<Event> events = eventRepository.findAll();
        allPosts.put("Publications", publications);
        allPosts.put("Events", events);
        return allPosts;
    }

    @Override
    public List<String> getRandomPictures() {
        return userRepository.fetchRandomPictures();
    }

    ////////////////// Setters ////////////////

    @Autowired
    public void setPublicationRepository(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
