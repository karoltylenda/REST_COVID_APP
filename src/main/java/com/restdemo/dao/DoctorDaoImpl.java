package com.restdemo.dao;

import com.restdemo.model.Doctor;

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
public class DoctorDaoImpl implements DoctorDao{

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger logger = Logger.getLogger(DoctorDaoImpl.class.getName());
    private Integer pesel;

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
        return Optional.of(Optional.ofNullable(entityManager.find(Doctor.class, id)).orElse(new Doctor()));
    }

    @Override
    public Optional<Doctor> getByPesel(Integer pesel) {
        try{
            return Optional.ofNullable(entityManager.createQuery("FROM Doctor where pesel like :pesel", Doctor.class).setParameter("pesel", pesel).getSingleResult());
        } catch (NoResultException e) {
            logger.warning(e.getMessage());
            return Optional.of(new Doctor());
        }
    }

}
