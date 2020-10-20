package com.restdemo.dao;

import com.restdemo.model.Patient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@Transactional
@Stateless
public class PatientDaoImpl implements PatientDao {

    private static final Logger logger = Logger.getLogger(PatientDaoImpl.class.getName());

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
        try {
            return Optional.ofNullable(entityManager.createQuery("from Patient where pesel like :pesel", Patient.class).setParameter("pesel", pesel).getSingleResult());
        } catch (NoResultException e){
            logger.warning(e.getMessage());
            return Optional.of(new Patient());
        }
    }

    @Override
    public Optional<Patient> getByLastName(String lastName) {
        try {
            return Optional.ofNullable(entityManager.createQuery("from Patient where lastName like :lastName", Patient.class).setParameter("lastName", lastName).getSingleResult());
        } catch (Exception e){
            logger.warning(e.getMessage());
            return Optional.of(new Patient());
        }
    }

}
