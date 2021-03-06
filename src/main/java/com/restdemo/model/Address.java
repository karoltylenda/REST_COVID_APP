package com.restdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String streetNr;
    private String localNr;
    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Person> patientSet;

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

    public Set<Person> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Person> patientSet) {
        this.patientSet = patientSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(district, address.district) &&
                Objects.equals(city, address.city) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(street, address.street) &&
                Objects.equals(streetNr, address.streetNr) &&
                Objects.equals(localNr, address.localNr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(district, city, postalCode, street, streetNr, localNr);
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
