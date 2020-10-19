package com.restdemo.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> getAll();
    void create(T t);
    void update(T t);
    void delete(T t);
    Optional<T> getById(Integer id);
}
