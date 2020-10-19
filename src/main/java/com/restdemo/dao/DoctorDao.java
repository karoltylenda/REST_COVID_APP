package com.restdemo.dao;

import com.restdemo.model.Doctor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Stateless
public class DoctorDao implements DAO<Doctor>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Doctor> getAll() {
        return entityManager.createQuery("FROM Doctor", Doctor.class).getResultList();
    }

    @Override
    public void create(Doctor doctor) {
        entityManager.persist(doctor);
    }

    @Override
    public void update(Doctor doctor) {
        entityManager.merge(doctor);
    }

    @Override
    public void delete(Doctor doctor) {
        entityManager.remove(doctor);
    }

    @Override
    public Optional<Doctor> getById(Integer id) {
        return Optional.ofNullable(entityManager.find(Doctor.class, id));
    }
}
