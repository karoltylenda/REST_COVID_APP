package com.restdemo.dto;

import com.restdemo.model.Address;
import com.restdemo.model.Patient;
import java.util.Set;

public class PatientDto {

    private Integer id;
    private String name;
    private String lastName;
    private Integer pesel;
    private boolean isDoctor;
    private Patient doctor;
    private Set<Patient> patientSet;
    private Address patientAddress;

    public PatientDto(Integer id, String name, String lastName, Integer pesel, boolean isDoctor, Patient doctor, Set<Patient> patientSet, Address patientAddress) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.isDoctor = isDoctor;
        this.doctor = doctor;
        this.patientSet = patientSet;
        this.patientAddress = patientAddress;
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

    public Patient getDoctor() {
        return doctor;
    }

    public void setDoctor(Patient doctor) {
        this.doctor = doctor;
    }

    public Set<Patient> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Patient> patientSet) {
        this.patientSet = patientSet;
    }

    public Address getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(Address patientAddress) {
        this.patientAddress = patientAddress;
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
                ", patientSet=" + patientSet +
                ", patientAddress=" + patientAddress +
                '}';
    }
}
