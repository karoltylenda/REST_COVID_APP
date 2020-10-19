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
    @Path("/query")
    public PatientDto getPatientByPesel(@QueryParam("pesel") Integer pesel){
//        return new PatientDto(1,"a", "a", 1234, null, null);
        return patientService.getByPesel(pesel);
    }

//    @GET
//    @Path("/query")
//    public PatientDto getPatientByLastName(@QueryParam("lastName") String lastName){
//        //TODO
//        return null;
//    }
}
