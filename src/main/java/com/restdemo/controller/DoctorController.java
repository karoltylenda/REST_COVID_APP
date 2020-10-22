package com.restdemo.controller;

import com.restdemo.dto.DoctorDto;
import com.restdemo.service.DoctorService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/doctor")
public class DoctorController {

    private static final Logger LOGGER = Logger.getLogger(DoctorController.class.getName());

    @Inject
    private DoctorService doctorService;

    @GET
    public List<DoctorDto> getAll(){
        return doctorService.getAll();
    }

    @GET
    @Path("/{id}")
    public DoctorDto getById(@PathParam("id") Integer id){
        return doctorService.getDoctorById(id);
    }

    @GET
    @Path("/getByPesel")
    public DoctorDto getByPesel(@QueryParam("pesel") Integer pesel){
        return doctorService.getDoctorByPesel(pesel);
    }

    @POST
    @Path("/add")
    public Response save(DoctorDto doctorDto){
        return Response.ok().build();
    }
}
