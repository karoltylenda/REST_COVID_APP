package com.restdemo.controller;


import com.restdemo.dto.PatientDto;
import com.restdemo.service.PatientService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
