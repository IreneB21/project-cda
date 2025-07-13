package com.hello.neighbors.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hello.neighbors.entity.dto.GeocodingResponseDto;
import com.hello.neighbors.service.GeocodingService;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Service
public class GeocodingServiceImpl implements GeocodingService {

    public GeocodingServiceImpl() {}

    @Override
    public Optional<double[]> geocodeAddress(String street, String postalCode, String city) {
        String query = String.format("%s, %s %s", street, postalCode, city);
        String apiKey = "pk.d5a89078d4b98d7346da1c61b5a17dc6";

        String url = UriComponentsBuilder.fromHttpUrl("https://us1.locationiq.com/v1/search")
                .queryParam("key", apiKey)
                .queryParam("q", query)
                .queryParam("format", "json")
                .queryParam("limit", "1")
                .toUriString();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        GeocodingResponseDto[] locations;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            locations = objectMapper.readValue(response.body(), GeocodingResponseDto[].class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        GeocodingResponseDto loc = locations[0];
        double[] coords = new double[]{loc.getParsedLat(), loc.getParsedLon()};
        return Optional.of(coords);
    }
}