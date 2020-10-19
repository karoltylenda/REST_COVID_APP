package com.restdemo.dao;

import com.restdemo.model.Patient;

import java.util.Optional;

public interface PatientDao extends DAO<Patient> {

    Optional<Patient> getByPesel(Integer pesel);
    Optional<Patient> getByLastName(String lastName);
}
