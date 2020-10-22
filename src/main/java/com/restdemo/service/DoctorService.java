package com.restdemo.service;

import com.restdemo.dao.PersonDao;
import com.restdemo.dto.DoctorDto;
import com.restdemo.dto.PersonDto;
import com.restdemo.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class DoctorService {

    @Inject
    private PersonDao personDao;

    public List<DoctorDto> getAll(){
        List<Person> doctors = personDao.getDoctors();
        List<DoctorDto> doctorsDto = mapDoctorsToDoctorsDto(doctors);
        return doctorsDto;
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
}
