package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.dto.GeocodingResponseDto;
import com.hello.neighbors.entity.dto.NominatimResponseDto;
import com.hello.neighbors.service.GeocodingService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.Optional;

@Service
public class GeocodingServiceImpl implements GeocodingService {

    private final RestTemplate restTemplate;

    public GeocodingServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

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

        GeocodingResponseDto[] response = restTemplate.getForObject(url, GeocodingResponseDto[].class);

        if (response != null && response.length > 0) {
            GeocodingResponseDto dto = response[0];
            if (dto.getLat() != null && dto.getLon() != null) {
                double lat = Double.parseDouble(dto.getLat());
                double lon = Double.parseDouble(dto.getLon());
                return Optional.of(new double[]{lat, lon});
            }
        }

        System.out.println("Coordonnées non trouvées pour : {} " + query);
        return Optional.of(new double[]{0.0, 0.0});
    }
}