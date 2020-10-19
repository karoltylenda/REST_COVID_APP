package com.restdemo.service;

import com.restdemo.dao.DAO;
import com.restdemo.dto.PatientDto;
import com.restdemo.model.Patient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class PatientService {

    @Inject
    private DAO<Patient> patientDAO;

    public List<PatientDto> getAll(){
        List<Patient> patientList = patientDAO.getAll();
        List<PatientDto> patientDtoList = mapPatientListToDtos(patientList);
        return patientDtoList;
    }

    public PatientDto getById(Integer id){
        Patient patient = patientDAO.getById(id).get();
        return new PatientDto(patient.getId(),
                patient.getName(),
                patient.getLastName(),
                patient.getPesel(),
                patient.getDoctor(),
                patient.getPatientAddress());
    }

    private List<PatientDto> mapPatientListToDtos(List<Patient> patientList) {
        return patientList.stream()
                .map(patient -> new PatientDto(patient.getId(),
                        patient.getName(),
                        patient.getLastName(),
                        patient.getPesel(),
                        patient.getDoctor(),
                        patient.getPatientAddress()))
                .collect(Collectors.toList());
    }
}
