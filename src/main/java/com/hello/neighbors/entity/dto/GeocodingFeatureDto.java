package com.hello.neighbors.entity.dto;

public class GeocodingFeatureDto {
    private GeocodingGeometryDto geometry;
    private GeocodingPropertiesDto properties;

    public GeocodingFeatureDto(GeocodingGeometryDto geometry, GeocodingPropertiesDto properties) {
        this.geometry = geometry;
        this.properties = properties;
    }

    public GeocodingGeometryDto getGeometry() {
        return geometry;
    }

    public void setGeometry(GeocodingGeometryDto geometry) {
        this.geometry = geometry;
    }

    public GeocodingPropertiesDto getProperties() {
        return properties;
    }

    public void setProperties(GeocodingPropertiesDto properties) {
        this.properties = properties;
    }
}
