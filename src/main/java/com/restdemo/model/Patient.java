package com.restdemo.model;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastName;
    @Column(unique = true)
    private Integer pesel;
    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;
    @ManyToOne(fetch = FetchType.EAGER)
    private Address patientAddress;

    public Patient() {
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Address getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(Address patientAddress) {
        this.patientAddress = patientAddress;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel=" + pesel +
                ", doctor=" + doctor +
                ", patientAddress=" + patientAddress +
                '}';
    }
}
