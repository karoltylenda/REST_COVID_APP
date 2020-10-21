package com.restdemo.controller;

import com.restdemo.dto.DoctorDto;
import com.restdemo.dto.PatientDto;
import com.restdemo.service.DoctorService;
import com.restdemo.service.PatientService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/doctor")
public class DoctorController {

    @Inject
    private DoctorService doctorService;

    @Inject
    private PatientService patientService;

    @GET
    public List<DoctorDto> getAll(){
        return doctorService.getAll();
    }

    @GET
    @Path("/{id}")
    public DoctorDto getById(@PathParam("id") Integer id){
        return doctorService.getById(id);
    }

    @GET
    @Path("/queryByPesel")
    public List<PatientDto> listByDoctorPesel(@QueryParam("pesel") Integer pesel){
        return patientService.getByDoctorPesel(pesel);
    }
}
