package com.restdemo.service;

import com.restdemo.dao.PersonDao;
import com.restdemo.dto.PatientDto;
import com.restdemo.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class PatientService {

    @Inject
    private PersonDao personDao;

    public List<PatientDto> getAll(){
        List<Person> patients = personDao.getPatients();
        List<PatientDto> patientsDto = mapPatientsToPatientsDto(patients);
        return patientsDto;
    }

    private List<PatientDto> mapPatientsToPatientsDto(List<Person> patients) {
        return patients.stream().map(person -> new PatientDto(person.getId(),
                person.getName(),
                person.getLastName(),
                person.getPesel(),
                person.isDoctor(),
                person.getDoctor(),
                person.getAddress()))
                .collect(Collectors.toList());
    }
}
