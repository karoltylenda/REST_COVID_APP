package com.restdemo.dto;

import com.restdemo.model.Address;
import com.restdemo.model.Person;

import java.util.Objects;
import java.util.Set;

public class PersonDto {

    private Integer id;
    private String name;
    private String lastName;
    private Integer pesel;
    private boolean isDoctor;
    private Person doctor;
    private Set<Person> patients;
    private Address address;

    public PersonDto(Integer id, String name, String lastName, Integer pesel, boolean isDoctor, Person doctor, Set<Person> patients, Address address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.isDoctor = isDoctor;
        this.doctor = doctor;
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

    public Person getDoctor() {
        return doctor;
    }

    public void setDoctor(Person doctor) {
        this.doctor = doctor;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDto)) return false;
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(pesel, personDto.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel=" + pesel +
                ", isDoctor=" + isDoctor +
                ", doctor=" + doctor +
                ", patients=" + patients +
                ", address=" + address +
                '}';
    }
}
