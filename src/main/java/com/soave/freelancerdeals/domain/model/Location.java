package com.soave.freelancerdeals.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

    private double lat;

    private double lng;

    private String address;

    private String city;

    private String state;

    @JsonProperty(value = "zipcode")
    private int zipCode;

    public Location(double lat, double lng, String address, String city, String state, int zipCode) {
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
