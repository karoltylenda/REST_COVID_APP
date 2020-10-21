package com.restdemo.service;

import com.restdemo.dao.DoctorDao;
import com.restdemo.dao.PatientDao;
import com.restdemo.dto.PatientDto;
import com.restdemo.model.Patient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class PatientService {

    @Inject
    private PatientDao patientDAO;

    @Inject
    private DoctorDao doctorDao;

    public List<PatientDto> getAll(){
        List<Patient> patientList = patientDAO.getAll();
        List<PatientDto> patientDtoList = mapPatientListToDtos(patientList);
        return patientDtoList;
    }

    public PatientDto getById(Integer id){
        return mapPatientToDto(patientDAO.getById(id).get());
    }

    public PatientDto getByPesel(Integer pesel){
        return mapPatientToDto(patientDAO.getByPesel(pesel).get());
    }

    public PatientDto getByLastName(String lastName){
        return mapPatientToDto(patientDAO.getByLastName(lastName).get());
    }

    public List<PatientDto> getByDoctorPesel(Integer pesel){
        Integer doctorId = doctorDao.getByPesel(pesel).get().getId();
        return mapPatientListToDtos(patientDAO.getByDoctorId(doctorId));
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

    private PatientDto mapPatientToDto(Patient patient){
        return new PatientDto(patient.getId(),
                patient.getName(),
                patient.getLastName(),
                patient.getPesel(),
                patient.getDoctor(),
                patient.getPatientAddress());
    }
}
