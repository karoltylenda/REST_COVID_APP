package com.restdemo.dao;

import com.restdemo.model.Patient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Stateless
public class PatientDaoImpl implements PatientDao {

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
        return Optional.of(Optional.ofNullable(entityManager.find(Patient.class, id)).orElse(new Patient()));
    }

    @Override
    public Optional<Patient> getByPesel(Integer pesel) {
        return Optional.of(Optional.ofNullable(entityManager.createQuery("from Patient where pesel like :pesel", Patient.class).setParameter("pesel", pesel).getSingleResult()).orElse(new Patient()));
    }

}
