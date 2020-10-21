package com.restdemo.dao;

import com.restdemo.model.Doctor;
import java.util.Optional;

public interface DoctorDao extends DAO<Doctor> {

    Optional<Doctor> getById(Integer id);
    Optional<Doctor> getByPesel(Integer pesel);
}
