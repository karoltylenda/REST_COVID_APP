package com.restdemo.dao;

import com.restdemo.model.Patient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
@Stateless
public class PatientDao implements DAO<Patient> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Patient> getAll() {
        return entityManager.createQuery("FROM Patient", Patient.class).getResultList();
    }

    @Override
    public void create(Patient patient) {
        entityManager.persist(patient);
    }

    @Override
    public void update(Patient patient) {
        entityManager.merge(patient);
    }

    @Override
    public void delete(Patient patient) {
        entityManager.remove(patient);
    }

    @Override
    public Optional<Patient> getById(Integer id) {
        return Optional.of(Optional.ofNullable(entityManager.find(Patient.class, id)).orElse(emptyPatient()));
    }

    public Optional<Patient> getByPesel(Integer pesel) {
        return Optional.of(Optional.ofNullable(entityManager.find(Patient.class, pesel)).orElseGet(this::emptyPatient));
    }

    private Patient emptyPatient(){
        Patient patient = new Patient();
        return patient;
    }
}
