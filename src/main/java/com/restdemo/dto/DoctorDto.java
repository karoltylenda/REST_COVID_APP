package com.restdemo.dto;

import com.restdemo.model.Patient;
import java.util.Set;

public class DoctorDto {

    private Integer id;
    private String name;
    private String lastName;
    private Integer pesel;

    public DoctorDto(Integer id, String name, String lastName, Integer pesel) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
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

}
