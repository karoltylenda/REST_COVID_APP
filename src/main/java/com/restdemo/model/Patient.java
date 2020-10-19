package com.restdemo.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastName;
    private Integer pesel;
    private boolean isDoctor;
    @ManyToOne
    private Patient doctor;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<Patient> patientSet;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(pesel, patient.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel=" + pesel +
                ", isDoctor=" + isDoctor +
                ", doctor=" + doctor +
                ", patientSet=" + patientSet +
                '}';
    }
}
