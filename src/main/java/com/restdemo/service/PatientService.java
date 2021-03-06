package com.restdemo.service;

import com.restdemo.dao.AddressDao;
import com.restdemo.dao.PersonDao;
import com.restdemo.dto.PatientDto;
import com.restdemo.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
public class PatientService {

    @Inject
    private PersonDao personDao;

    @Inject
    private AddressDao addressDao;

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

    public void addPatient(String name, String lastName, Integer pesel, Integer doctorId, Integer addressId) {
        Person patient = new Person();
        Person doctor = personDao.getByDoctorId(doctorId).get();

        patient.setName(name);
        patient.setLastName(lastName);
        patient.setPesel(pesel);
        patient.setDoctor(false);
        patient.setDoctor(personDao.getByDoctorId(doctorId).get());
        patient.setAddress(addressDao.getById(addressId).get());
        personDao.create(patient);

        Set<Person> patients = doctor.getPatients();
        patients.add(personDao.getByPesel(pesel).get());
        doctor.setPatients(patients);
        personDao.update(doctor);

    }

    public PatientDto getById(Integer patientId) {
        return mapPatientToPatientDto(personDao.getById(patientId).get());
    }

    public void update(Integer patientId, String name, String lastName, Integer pesel, Integer doctorId) {
        Person patient = personDao.getById(patientId).get();
        patient.setName(name);
        patient.setLastName(lastName);
        patient.setPesel(pesel);
        patient.setDoctor(personDao.getByDoctorId(doctorId).get());
        personDao.update(patient);
    }
}
