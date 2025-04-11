package com.hello.neighbors.service.impl;

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
import java.util.Optional;

@Service
public class GeocodingServiceImpl implements GeocodingService {

    private final RestTemplate restTemplate;

    public GeocodingServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Optional<double[]> geocodeAddress(String street, String postalCode, String city) {
        String url = UriComponentsBuilder.fromHttpUrl("https://nominatim.openstreetmap.org/search")
                .queryParam("street", street)
                .queryParam("postalcode", postalCode)
                .queryParam("city", city)
                .queryParam("format", "json")
                .queryParam("limit", 1)
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "YourAppName");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<NominatimResponseDto[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, NominatimResponseDto[].class);

        if (response.getBody() != null && response.getBody().length > 0) {
            double lat = Double.parseDouble(response.getBody()[0].getLat());
            double lon = Double.parseDouble(response.getBody()[0].getLon());
            return Optional.of(new double[]{lat, lon});
        }
        return Optional.empty();
    }
}
