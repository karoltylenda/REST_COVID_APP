package com.restdemo.controller;

import com.restdemo.dto.AddressDto;
import com.restdemo.dto.PatientDto;
import com.restdemo.service.AddressService;
import com.restdemo.service.PatientService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/address")
public class AddressController {

    @Inject
    private AddressService addressService;

    @Inject
    private PatientService patientService;

    @GET
    public List<AddressDto> getAll(){
        return addressService.getAll();
    }

    @GET
    @Path("/getByCity")
    public List<PatientDto> getByCity(@QueryParam("city") String city){
        return patientService.getByCity(city);
    }

    @GET
    @Path("/getByDistrict")
    public List<PatientDto> getByDistrict(@QueryParam("district") String district){
        return patientService.getByDistrict(district);
    }
}
