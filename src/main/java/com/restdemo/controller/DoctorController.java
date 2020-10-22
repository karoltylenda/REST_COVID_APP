package com.restdemo.controller;

import com.restdemo.dto.DoctorDto;
import com.restdemo.service.DoctorService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/doctor")
public class DoctorController {

    @Inject
    private DoctorService doctorService;

    @GET
    public List<DoctorDto> getAll(){
        return doctorService.getAll();
    }
}
