package com.restdemo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String district;
    private String city;
    private String postalCode;
    private String street;
    private String streetNr;
    private String localNr;
    @OneToMany(mappedBy = "patientAddress", fetch = FetchType.EAGER)
    private Set<Patient> patientSet;

    public Address() {
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

    public Set<Patient> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Patient> patientSet) {
        this.patientSet = patientSet;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", street='" + street + '\'' +
                ", streetNr='" + streetNr + '\'' +
                ", localNr='" + localNr + '\'' +
                ", patientSet=" + patientSet +
                '}';
    }
}
