package com.restdemo.service;

import com.restdemo.dao.AddressDao;
import com.restdemo.dao.PersonDao;
import com.restdemo.dto.DoctorDto;
import com.restdemo.model.Person;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
public class DoctorService {

    @Inject
    private PersonDao personDao;

    @Inject
    private AddressDao addressDao;

    public List<DoctorDto> getAll(){
        List<Person> doctors = personDao.getDoctors();
        List<DoctorDto> doctorsDto = mapDoctorsToDoctorsDto(doctors);
        return doctorsDto;
    }

    public DoctorDto getDoctorById(Integer id){
        return mapPersonToDoctorDto(personDao.getByDoctorId(id).get());
    }

    public DoctorDto getDoctorByPesel(Integer pesel){
        return mapPersonToDoctorDto(personDao.getByDoctorPesel(pesel).get());
    }

    private List<DoctorDto> mapDoctorsToDoctorsDto(List<Person> doctors) {
        return doctors.stream().map(person -> new DoctorDto(person.getId(),
                person.getName(),
                person.getLastName(),
                person.getPesel(),
                person.isDoctor(),
                person.getPatients(),
                person.getAddress()))
                .collect(Collectors.toList());
    }

    private DoctorDto mapPersonToDoctorDto(Person person){
        return new DoctorDto(person.getId(),
                person.getName(),
                person.getLastName(),
                person.getPesel(),
                person.isDoctor(),
                person.getPatients(),
                person.getAddress());
    }


    public void addDoctor(String name, String lastName, Integer pesel, boolean isDoctor, Integer addressId) {
        Person doctor = new Person();
        doctor.setName(name);
        doctor.setLastName(lastName);
        doctor.setPesel(pesel);
        doctor.setDoctor(isDoctor);
        doctor.setAddress(addressDao.getById(addressId).get());
        personDao.create(doctor);
    }
}
