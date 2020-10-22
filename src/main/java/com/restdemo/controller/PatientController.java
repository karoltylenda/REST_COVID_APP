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
    public List<PatientDto> getAll(){
        return patientService.getAll();
    }

    @GET
    @Path("/getByPesel")
    public PatientDto getByPesel(@QueryParam("pesel") Integer pesel){
        return patientService.getByPesel(pesel);
    }

    @GET
    @Path("/getByLastName")
    public PatientDto getByLastName(@QueryParam("lastName") String lastName){
        return patientService.getByLastName(lastName);
    }
}
