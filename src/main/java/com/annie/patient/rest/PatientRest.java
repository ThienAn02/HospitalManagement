package com.annie.patient.rest;

import com.annie.patient.dto.PatientRequestDto;
import com.annie.patient.service.PatientService;
import com.annie.response.ResponseModel;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/patients")
public class PatientRest {

    @Inject
    private PatientService patientService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPatients() {
        return Response.ok().entity(ResponseModel.builder()
                .data(patientService.getAllPatients())
                .build()).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/json")
    public Response addPatient(@Valid PatientRequestDto patientRequest) {
        return Response.status(Response.Status.CREATED).entity(ResponseModel.builder()
                .data(patientService.addPatient(patientRequest))
                .build()).build();
    }

}