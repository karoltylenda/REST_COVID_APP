package com.restdemo.dao;

import com.restdemo.model.Address;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Stateless
public class AddressDaoImpl implements DAO<Address> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Address> getAll() {
        return entityManager.createQuery("FROM Address", Address.class).getResultList();
    }

    @Override
    public void create(Address address) {
        entityManager.persist(address);
    }

    @Override
    public void update(Address address) {
        entityManager.merge(address);
    }

    @Override
    public void delete(Address address) {
        entityManager.remove(address);
    }

    @Override
    public Optional<Address> getById(Integer id) {
        return Optional.ofNullable(entityManager.find(Address.class, id));
    }
}
