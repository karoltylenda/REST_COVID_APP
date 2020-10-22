package com.restdemo.service;

import com.restdemo.dao.PersonDao;
import com.restdemo.dto.PersonDto;
import com.restdemo.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
public class PersonService {

    @Inject
    private PersonDao personDao;

    public List<PersonDto> getAll(){
        List<Person> personList = personDao.getAll();
        List<PersonDto> personDtoList = mapPersonListToDtos(personList);
        return personDtoList;
    }

    public List<PersonDto> getAllDoctors(){
        return mapPersonListToDtos(personDao.getDoctors());
    }

    public PersonDto getById(Integer id){
        return mapPersonToDto(personDao.getById(id).get());
    }

    public PersonDto getByPesel(Integer pesel){
        return mapPersonToDto(personDao.getByPesel(pesel).get());
    }

    public List<PersonDto> getByDoctorPesel(Integer pesel){
        PersonDto doctor = mapPersonToDto(personDao.getByPesel(pesel).get());
        if (doctor.isDoctor()){
            return mapPersonSetToDtos(doctor.getPatients());
        }
        else {
            List<PersonDto> personDtos = new ArrayList<>();
            return personDtos;
        }
    }

    private List<PersonDto> mapPersonSetToDtos(Set<Person> personSet){
        return personSet.stream().map(person -> new PersonDto(person.getId(),
                person.getName(),
                person.getLastName(),
                person.getPesel(),
                person.isDoctor(),
                person.getDoctor(),
                person.getPatients(),
                person.getAddress())).collect(Collectors.toList());
    }

    private PersonDto mapPersonToDto(Person person) {
        return new PersonDto(person.getId(),
                person.getName(),
                person.getLastName(),
                person.getPesel(),
                person.isDoctor(),
                person.getDoctor(),
                person.getPatients(),
                person.getAddress());
    }

    private List<PersonDto> mapPersonListToDtos(List<Person> personList) {
        return personList.stream().map(person -> new PersonDto(person.getId(),
                person.getName(),
                person.getLastName(),
                person.getPesel(),
                person.isDoctor(),
                person.getDoctor(),
                person.getPatients(),
                person.getAddress())).collect(Collectors.toList());
    }
}
