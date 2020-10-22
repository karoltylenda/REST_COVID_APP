package com.restdemo.dto;

import com.restdemo.model.Address;
import com.restdemo.model.Person;

public class PatientDto {

    private Integer id;
    private String name;
    private String lastName;
    private Integer pesel;
    private boolean isDoctor;
    private Person doctor;
    private Address address;

    public PatientDto(Integer id, String name, String lastName, Integer pesel, boolean isDoctor, Person doctor, Address address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.isDoctor = isDoctor;
        this.doctor = doctor;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPesel() {
        return pesel;
    }

    public void setPesel(Integer pesel) {
        this.pesel = pesel;
    }

    public boolean isDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean doctor) {
        isDoctor = doctor;
    }

    public Person getDoctor() {
        return doctor;
    }

    public void setDoctor(Person doctor) {
        this.doctor = doctor;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel=" + pesel +
                ", isDoctor=" + isDoctor +
                ", doctor=" + doctor +
                ", address=" + address +
                '}';
    }
}
