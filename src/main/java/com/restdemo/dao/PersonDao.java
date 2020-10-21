package com.restdemo.dao;

import com.restdemo.model.Person;

import java.util.Optional;

public interface PersonDao extends DAO<Person> {
    Optional<Person> getByPesel(Integer pesel);
}
