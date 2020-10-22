package com.restdemo.dto;

import com.restdemo.model.Address;
import com.restdemo.model.Person;
import java.util.Set;

public class DoctorDto {

    private Integer id;
    private String name;
    private String lastName;
    private Integer pesel;
    private boolean isDoctor;
    private Set<Person> patients;
    private Address address;

    public DoctorDto(Integer id, String name, String lastName, Integer pesel, boolean isDoctor, Set<Person> patients, Address address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.isDoctor = isDoctor;
        this.patients = patients;
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

    public Set<Person> getPatients() {
        return patients;
    }

    public void setPatients(Set<Person> patients) {
        this.patients = patients;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DoctorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel=" + pesel +
                ", isDoctor=" + isDoctor +
                ", patients=" + patients +
                ", address=" + address +
                '}';
    }
}
