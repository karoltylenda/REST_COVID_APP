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

    public PatientDto getByPesel(Integer pesel){
        return mapPatientToPatientDto(personDao.getByPesel(pesel).get());
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

    private PatientDto mapPatientToPatientDto(Person patient){
        return new PatientDto(patient.getId(),
                patient.getName(),
                patient.getLastName(),
                patient.getPesel(),
                patient.isDoctor(),
                patient.getDoctor(),
                patient.getAddress());
    }

    public PatientDto getByLastName(String lastName) {
        return mapPatientToPatientDto(personDao.getByLastName(lastName).get());
    }

    public List<PatientDto> getByCity(String city) {
        return mapPatientsToPatientsDto(personDao.getByCity(city));
    }

    public List<PatientDto> getByDistrict(String district) {
        return mapPatientsToPatientsDto(personDao.getByDistrict(district));
    }
}
