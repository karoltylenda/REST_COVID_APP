package com.restdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restdemo.model.Patient;

import java.util.Set;

public class DoctorDto {

    private Integer id;
    private String name;
    private String lastName;
    private Integer pesel;
    private Set<Patient> patients;

    public DoctorDto(Integer id, String name, String lastName, Integer pesel, Set<Patient> patients) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.patients = patients;
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

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
