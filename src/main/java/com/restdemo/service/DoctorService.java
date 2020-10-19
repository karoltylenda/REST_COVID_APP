package com.restdemo.service;


import com.restdemo.dao.DAO;
import com.restdemo.dto.DoctorDto;
import com.restdemo.model.Doctor;
import jdk.dynalink.linker.LinkerServices;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class DoctorService {

    @Inject
    private DAO<Doctor> doctorDAO;

    public List<DoctorDto> getAll(){
        List<Doctor> doctorList = doctorDAO.getAll();
        List<DoctorDto> doctorDtoList = mapDoctorListToDtos(doctorList);
        return doctorDtoList;
    }

    private List<DoctorDto> mapDoctorListToDtos(List<Doctor> doctorList) {
        return doctorList.stream()
                .map(doctor -> new DoctorDto(doctor.getId(),
                        doctor.getName(),
                        doctor.getLastName(),
                        doctor.getPesel(),
                        doctor.getPatientSet()))
                .collect(Collectors.toList());
    }
}
