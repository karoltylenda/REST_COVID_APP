package com.restdemo.dao;

import com.restdemo.model.Address;
import com.restdemo.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Transactional
@Stateless
public class PersonDaoImpl implements PersonDao {

    private static final Logger LOGGER = Logger.getLogger(PersonDaoImpl.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> getAll() {
        return entityManager.createQuery("FROM Person", Person.class).getResultList();
    }

    @Override
    public void create(Person person) {
        entityManager.persist(person);
    }

    @Override
    public void update(Person person) {
        entityManager.merge(person);
    }

    @Override
    public void delete(Person person) {
        entityManager.remove(person);
    }

    @Override
    public Optional<Person> getById(Integer id) {
        return Optional.of(Optional.ofNullable(entityManager.find(Person.class, id)).orElse(new Person()));
    }

    @Override
    public Optional<Person> getByPesel(Integer pesel) {
        try {
            return Optional.ofNullable(entityManager.createQuery("FROM Person where pesel like : pesel", Person.class).setParameter("pesel", pesel).getSingleResult());
        } catch (NoResultException e) {
            LOGGER.warning(e.getMessage());
            return Optional.of(new Person());
        }
    }

    @Override
    public List<Person> getDoctors() {
        return entityManager.createQuery("FROM Person where isDoctor like :isDoctor", Person.class).setParameter("isDoctor", true).getResultList();
    }

    @Override
    public List<Person> getPatients() {
        return entityManager.createQuery("FROM Person", Person.class).getResultList();
    }

    @Override
    public Optional<Person> getByDoctorId(Integer id) {
        Optional<Person> personOptional = getById(id);
        if (personOptional.get().isDoctor()){
            return personOptional;
        }
        else return Optional.of(new Person());
    }

    @Override
    public Optional<Person> getByDoctorPesel(Integer pesel) {
        Optional<Person> personOptional = getByPesel(pesel);
        if (personOptional.get().isDoctor()){
            return personOptional;
        }
        else return Optional.of(new Person());
    }

    @Override
    public Optional<Person> getByLastName(String lastName) {
        try {
            return Optional.ofNullable(entityManager.createQuery("FROM Person where lastName like : lastName", Person.class).setParameter("lastName", lastName).getSingleResult());
        } catch (NoResultException e){
            LOGGER.warning(e.getMessage());
            return Optional.of(new Person());
        }
    }

    @Override
    public List<Person> getByCity(String city) {
        return entityManager.createQuery("FROM Person where address.city like : city", Person.class).setParameter("city", city).getResultList();
    }

    @Override
    public List<Person> getByDistrict(String district) {
        return entityManager.createQuery("FROM Person where address.district like : district", Person.class).setParameter("district", district).getResultList();
    }
}
