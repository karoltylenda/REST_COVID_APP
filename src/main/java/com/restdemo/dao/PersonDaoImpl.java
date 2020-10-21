package com.restdemo.dao;

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

    private static final Logger logger = Logger.getLogger(PersonDaoImpl.class.getName());

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
            logger.warning(e.getMessage());
            return Optional.of(new Person());
        }
    }
}
