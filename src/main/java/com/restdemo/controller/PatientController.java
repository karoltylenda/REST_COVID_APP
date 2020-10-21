package com.restdemo.controller;


import com.restdemo.dto.PatientDto;
import com.restdemo.service.PatientService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/patient")
public class PatientController {

    @Inject
    private PatientService patientService;

    @GET
    public List<PatientDto> getALl(){
        return patientService.getAll();
    }

    @GET
    @Path("/{id}")
    public PatientDto getPatientById(@PathParam("id") Integer id){
        return patientService.getById(id);
    }

    @GET
    @Path("/queryByPesel")
    public PatientDto getPatientByPesel(@QueryParam("pesel") Integer pesel){
        return patientService.getByPesel(pesel);
    }

    @GET
    @Path("/queryByLastName")
    public PatientDto getPatientByLastName(@QueryParam("lastName") String lastName){
        return patientService.getByLastName(lastName);
    }

    @GET
    @Path("/queryByDoctorPesel")
    public List<PatientDto> getPatientByDoctorPesel(@QueryParam("pesel") Integer pesel){
        return null;
    }
}
