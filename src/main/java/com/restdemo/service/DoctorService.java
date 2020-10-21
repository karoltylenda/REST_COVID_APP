package com.restdemo.service;


import com.restdemo.dao.DAO;
import com.restdemo.dao.DoctorDao;
import com.restdemo.dto.DoctorDto;
import com.restdemo.model.Doctor;
import jdk.dynalink.linker.LinkerServices;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class DoctorService {

    @Inject
    private DoctorDao doctorDao;

    public List<DoctorDto> getAll(){
        List<Doctor> doctorList = doctorDao.getAll();
        List<DoctorDto> doctorDtoList = mapDoctorListToDtos(doctorList);
        return doctorDtoList;
    }

    public DoctorDto getById(Integer id){
        return mapDoctorToDto(doctorDao.getById(id).get());
    }

    public DoctorDto getByPesel(Integer pesel){
        return mapDoctorToDto(doctorDao.getByPesel(pesel).get());
    }

    private DoctorDto mapDoctorToDto(Doctor doctor) {
        return new DoctorDto(doctor.getId(),
                doctor.getName(),
                doctor.getLastName(),
                doctor.getPesel(),
                doctor.getPatients());
    }

    private List<DoctorDto> mapDoctorListToDtos(List<Doctor> doctorList) {
        return doctorList.stream()
                .map(doctor -> new DoctorDto(doctor.getId(),
                        doctor.getName(),
                        doctor.getLastName(),
                        doctor.getPesel(),
                        doctor.getPatients()))
                .collect(Collectors.toList());
    }
}
