package com.hello.neighbors.service;

import java.util.Optional;

public interface GeocodingService {

    Optional<double[]> geocodeAddress(String street, String postalCode, String city);
}
