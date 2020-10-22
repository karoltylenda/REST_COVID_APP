package com.restdemo.dao;

import com.restdemo.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao extends DAO<Person> {
    Optional<Person> getByPesel(Integer pesel);
    List<Person> getDoctors();
    List<Person> getPatients();
    Optional<Person> getByDoctorId(Integer id);
    Optional<Person> getByDoctorPesel(Integer pesel);

}
