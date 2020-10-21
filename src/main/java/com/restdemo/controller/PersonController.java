package com.restdemo.controller;


import com.restdemo.dao.PersonDao;
import com.restdemo.dto.PersonDto;
import com.restdemo.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/person")
public class PersonController {

    @Inject
    private PersonService personService;

    @GET
    public List<PersonDto> getAll(){
        return personService.getAll();
    }

    @GET
    @Path("/{id}")
    public PersonDto getById(@PathParam("id") Integer id){
        return personService.getById(id);
    }

    @GET
    @Path("/patient")
    public PersonDto getByPesel(@QueryParam("pesel") Integer pesel){
        return personService.getByPesel(pesel);
    }

    @GET
    @Path("/doctor")
    public List<PersonDto> getByDoctorPesel(@QueryParam("pesel") Integer pesel){
        return personService.getByDoctorPesel(pesel);
    }
}
