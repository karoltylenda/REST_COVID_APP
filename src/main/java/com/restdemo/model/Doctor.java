package com.restdemo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastName;
    @Column(unique = true)
    private Integer pesel;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Patient> patientSet;

    public Doctor(Integer id, String name, String lastName, Integer pesel, Set<Patient> patientSet) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.patientSet = patientSet;
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

    public Set<Patient> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Patient> patientSet) {
        this.patientSet = patientSet;
    }
}
