package com.restdemo.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restdemo.model.Person;

import java.util.Set;

public class AddressDto {

    private Integer id;
    private String district;
    private String city;
    private String postalCode;
    private String street;
    private String streetNr;
    private String localNr;
    @JsonIgnore
    private Set<Person> patientSet;

    public AddressDto(Integer id, String district, String city, String postalCode, String street, String streetNr, String localNr, Set<Person> patientSet) {
        this.id = id;
        this.district = district;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.streetNr = streetNr;
        this.localNr = localNr;
        this.patientSet = patientSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public String getLocalNr() {
        return localNr;
    }

    public void setLocalNr(String localNr) {
        this.localNr = localNr;
    }

    public Set<Person> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Person> patientSet) {
        this.patientSet = patientSet;
    }

}
